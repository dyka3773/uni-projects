# -*- coding: utf-8 -*-
"""MyResNet20.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1CTIyNbxs5rtueqLcDFN2aN8vpXnCzrSm
"""

from google.colab import drive

import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import numpy as np
import os
import time
from numpy.linalg import inv, norm
from IPython.display import display 
import pandas


drive.mount("/content/drive")
os.chdir('/content/drive/MyDrive/Xrays/')
print('\n',os.getcwd())
print("\n")
print(os.listdir())

save_dir = os.path.join(os.getcwd(),'saved_models')

##Imports for the Learning and the plotting
import keras
import tensorflow as tf

from tensorflow.keras.utils import plot_model
from tensorflow.keras.layers import Dense, Conv2D, BatchNormalization, Activation, Concatenate, \
                                    AveragePooling2D, Input, Flatten, MaxPooling2D
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.callbacks import ModelCheckpoint, LearningRateScheduler
from tensorflow.keras.callbacks import ReduceLROnPlateau
from tensorflow.keras.regularizers import l2
from tensorflow.keras import backend as K
from tensorflow.keras.models import Model


##Import for preprocessing
from tensorflow.keras.preprocessing.image import ImageDataGenerator

from PIL import Image

def resize(image_pil, width, height):
    '''
    Resize PIL image keeping ratio and using white background.
    '''
    ratio_w = width / image_pil.width
    ratio_h = height / image_pil.height
    if ratio_w < ratio_h:
        # It must be fixed by width
        resize_width = width
        resize_height = round(ratio_w * image_pil.height)
    else:
        # Fixed by height
        resize_width = round(ratio_h * image_pil.width)
        resize_height = height
    image_resize = image_pil.resize((resize_width, resize_height), Image.ANTIALIAS)
    background = Image.new('RGBA', (width, height), (0, 0, 0, 255))
    offset = (round((width - resize_width) / 2), round((height - resize_height) / 2))
    background.paste(image_resize, offset)
    return background.convert('RGB')

width = height = 170

data= pandas.read_csv('/content/drive/MyDrive/Xrays/labels_train.csv', header=None, usecols=[0,1], names=['file_name', 'class_id'])

labels = data['class_id'].values
labels = labels[1:]
img_name = data['file_name'].values
img_name = img_name[1:]

labels = np.array(labels)
print(labels.shape)   
print(labels)

class_0=class_1=class_2=0

for i in labels:
  if i=='0':
    class_0 += 1
  elif i=='1':
    class_1 += 1
  else:
    class_2 += 1

plt.subplot(111)
plt.bar(['class_0','class_1','class_2'],[class_0, class_1, class_2])
plt.show()

train_imgs = []
for i in range(img_name.size):
  img = Image.open('/content/drive/MyDrive/Xrays/train_images/{train_image}'.format(train_image=img_name[i]))
  train_imgs.append(img)

print("Loaded Training data")

for i in range(img_name.size):
  train_imgs[i]= resize(train_imgs[i], width, height)

for i in range(img_name.size):
  train_imgs[i]= np.asarray(train_imgs[i])

train_imgs = np.array(train_imgs, dtype="float32")/255.0

print(train_imgs.shape)

depth = 20

num_classes = 3

from sklearn.model_selection import train_test_split

x_train, x_test, y_train, y_test = train_test_split(train_imgs,labels, test_size=0.3)

input_shape = x_train.shape[1:]

x_train_mean = np.mean(x_train, axis=0)
print('x_train_mean:',x_train_mean)
x_train -= x_train_mean
x_test -= x_train_mean

print('x_train shape:', x_train.shape)
print(x_train.shape[0], 'train samples')
print(x_test.shape[0], 'test samples')

t_train = keras.utils.to_categorical(y_train, num_classes)
t_test = keras.utils.to_categorical(y_test, num_classes)

print('y_train (labels) shape:', y_train.shape)
print('t_train (one-hot rep) shape:', t_train.shape)

#Releasing Memory
train_imgs = []
train_imgs = None
del train_imgs
labels = []
labels = None
del labels

y_test = []
y_test = None
del y_test

y_train = []
y_train = None
del y_train

def resnet_layer(inputs,
                 num_filters=16,
                 kernel_size=3,
                 strides=1,
                 activation='relu',
                 batch_normalization=True,
                 conv_first=True):
    conv = Conv2D(num_filters,
                  kernel_size=kernel_size,
                  strides=strides,
                  padding='same',
                  kernel_initializer='he_normal',
                  kernel_regularizer=l2(1e-4))

    x = inputs
    if conv_first:
        x = conv(x)
        if batch_normalization:
            x = BatchNormalization()(x)
        if activation is not None:
            x = Activation(activation)(x)
    else:
        if batch_normalization:
            x = BatchNormalization()(x)
        if activation is not None:
            x = Activation(activation)(x)
        x = conv(x)
    return x

def resnet_v1(input_shape, depth, num_classes=3):
    if (depth - 2) % 6 != 0:
        raise ValueError('depth should be 6n+2 (eg 20, 32, 44 in [a])')
    # Start model definition.
    num_filters = 16
    num_res_blocks = int((depth - 2) / 6)

    inputs = Input(shape=input_shape)
    x = resnet_layer(inputs=inputs)
    # Instantiate the stack of residual units
    for stack in range(3):
        for res_block in range(num_res_blocks):
            strides = 1
            if stack > 0 and res_block == 0:  # first layer but not first stack
                strides = 2  # downsample
            y = resnet_layer(inputs=x,
                             num_filters=num_filters,
                             strides=strides)
            y = resnet_layer(inputs=y,
                             num_filters=num_filters,
                             activation=None)
            if stack > 0 and res_block == 0:  # first layer but not first stack
                # linear projection residual shortcut connection to match
                # changed dims
                x = resnet_layer(inputs=x,
                                 num_filters=num_filters,
                                 kernel_size=2, ### originally: 1,
                                 strides=strides,
                                 activation=None,
                                 batch_normalization=False)
            x = keras.layers.add([x, y])
            
            x = Activation('relu')(x)
        num_filters *= 2

    # Add classifier on top.
    # v1 does not use BN after last shortcut connection-ReLU
    x = MaxPooling2D(pool_size=8)(x)
    y = Flatten()(x)
    outputs = Dense(num_classes,
                    activation='softmax',
                    kernel_initializer='he_normal')(y)

    # Instantiate model.
    model = Model(inputs=inputs, outputs=outputs)
    print('Model parameters: {:d}'.format(model.count_params()))
    return model

def lr_schedule(epoch):
  lr = 1e-2
  if (epoch>180) :
      lr *= 0.5e-3
  elif epoch > 160:
      lr *= 1e-3
  elif epoch > 120:
      lr *= 1e-2
  elif epoch > 80:
      lr *= 1e-1
  return lr

class MyCallback(keras.callbacks.Callback):
    tstart = None
    def on_train_begin(self, logs={}):
        return
    
    def on_train_end(self, logs={}):
        return
    
    def on_epoch_begin(self, epoch, logs={}):
        self.tstart = time.time()
        print('epoch:{:03d}'.format(epoch+1), end=', ')
        return
    
    def on_epoch_end(self, epoch, logs={}):
        print('loss:{:8.6f}, acc:{:8.6f},  val_loss:{:8.6f}, val_acc:{:8.6f},  val_acc-acc = {:5.2f}%,  lr:{:0.6f}  [{:0.2f} sec]'.format(
                logs.get('loss'), logs.get('acc'),
                logs.get('val_loss'), logs.get('val_acc'),
                100*(logs.get('val_acc')-logs.get('acc')),
                K.eval(self.model.optimizer.lr),
                time.time()-self.tstart))
        return
    
    def on_batch_begin(self, batch, logs={}):
        return
    
    def on_batch_end(self, batch, logs={}):
        return

model = resnet_v1(input_shape=input_shape, depth=depth)
    
model.compile(loss="categorical_crossentropy",
              optimizer=Adam(lr=lr_schedule(0)),
              metrics=['acc'])
model.summary()

plot_model(model, show_shapes=True, dpi=48)

# Training parameters
batch_size = 32  # orig paper trained all networks with batch_size=128
epochs = 200

# Prepare model model saving directory.
model_name = 'resnet20-e{epoch:04d}-loss{loss:.3f}-acc{acc:.3f}-valloss{val_loss:.3f}-valacc{val_acc:.3f}.h5'
if not os.path.isdir(save_dir):
    os.makedirs(save_dir)
filepath = os.path.join(save_dir, model_name)

# Prepare callbacks for model saving and for learning rate adjustment.
checkpoint = ModelCheckpoint(filepath=filepath,
                             monitor='val_acc',
                             verbose=1,
                             save_best_only=True)

lr_scheduler = LearningRateScheduler(lr_schedule)

lr_reducer = ReduceLROnPlateau(factor=np.sqrt(0.1),
                               cooldown=0,
                               patience=5,
                               min_lr=0.5e-6)

# This will do preprocessing and realtime data augmentation:
datagen = ImageDataGenerator(
  featurewise_center=False,  # set input mean to 0 over the dataset
  samplewise_center=False,  # set each sample mean to 0
  featurewise_std_normalization=False,  # divide inputs by std of the dataset
  samplewise_std_normalization=False,  # divide each input by its std
  zca_whitening=False,  # apply ZCA whitening
  rotation_range = 30,  # randomly rotate images in the range (degrees, 0 to 180)
  zoom_range = 0.2, # Randomly zoom image 
  width_shift_range=0.1,  # randomly shift images horizontally (fraction of total width)
  height_shift_range=0.1,  # randomly shift images vertically (fraction of total height)
  horizontal_flip = True,  # randomly flip images
  vertical_flip=False)  # randomly flip images

# Compute quantities required for featurewise normalization

datagen.fit(x_train)


# Fit the model on the batches generated by datagen.flow().
history = model.fit(datagen.flow(x_train, t_train, batch_size=batch_size*4), 
                    validation_data=(x_test, t_test), epochs=epochs, verbose=0, 
                    workers=4, steps_per_epoch = int(x_train.shape[0]/batch_size), 
                    callbacks=[lr_reducer, lr_scheduler, MyCallback(), checkpoint])

# Score trained model.
scores = model.evaluate(x_test, t_test, verbose=1)
print('Test loss:', scores[0])
print('Test accuracy:', scores[1])

plt.figure(figsize=(10,8))
plt.plot(history.history['acc'])
plt.plot(history.history['val_acc'])
plt.xlabel('Epochs')
plt.ylabel('%')
plt.legend(('acc','val-acc'))
plt.grid(b=True)

#Releasing Memory
x_train = []
x_train = None
del x_train
t_train = []
t_train = None
del t_train

x_test = []
x_test = None
del x_test

t_test = []
t_test = None
del t_test

datagen = None
del datagen

history = None
del history

test_imgs_paths = os.listdir('/content/drive/MyDrive/Xrays/test_images/')
test_imgs = []
for path in test_imgs_paths:
  img = Image.open('/content/drive/MyDrive/Xrays/test_images/{test_image}'.format(test_image=path))
  test_imgs.append(img)

print("Loaded Test data")

for i in range(len(test_imgs_paths)):
  test_imgs[i]= resize(test_imgs[i], width, height)
  test_imgs[i]= np.asarray(test_imgs[i])

test_imgs = np.array(test_imgs, dtype="float32")/255.0

print(test_imgs.shape)

test_imgs -= x_train_mean

predictions = model.predict(test_imgs)

def getMaxIndex(list):
  maxim= max(list)
  for i in range(len(list)):
    if maxim == list[i]:
      return i

import csv

with open('submission_resnet20_170p_DataGen_MaxPool_val_acc0.817.csv', mode='w') as submission_file:
    submission_file = csv.writer(submission_file, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)

    submission_file.writerow(['file_name', 'class_id'])
    j=0
    for i  in predictions:
      #print("image : {img} \t\tclass : {i}".format(img=test_imgs_paths[j], i=getMaxIndex(i)))
      submission_file.writerow(['{img}'.format(img=test_imgs_paths[j]), '{i}'.format(i=getMaxIndex(i))])
      j+=1

print("Done")