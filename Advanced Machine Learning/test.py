# -*- coding: utf-8 -*-
"""
Created on Sat Dec 26 13:32:39 2020

@author: user
"""
import numpy as np
import pandas as pd
df = pd.read_csv('Submission/labels_train.csv',header=None , usecols=[0], names=['file_name', 'class_id'])


data_labels = np.array(df[1:])
print(data_labels[0].toString())