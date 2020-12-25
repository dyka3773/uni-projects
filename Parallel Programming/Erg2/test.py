import urllib.request as gimme
import os, glob
import threading

def knowWhereToGo(i):       # Didn't know how else to index the files
    i = i/10
    i = int(i)
    i=i*10
    return i

def downloadThisURL(url, i):
    j = knowWhereToGo(i)
    try:
        fid = gimme.urlopen(url)
        webpage = str(fid.read())
    except:
        webpage = "Trouble connecting to Server. Sorry for the inconvinience..."
        
    s = "\n--------------------------------------------------------------------\n"
    st = s+'\n{i}.\t'.format(i=i)+url+s
    
    f = open('./Webpages/pages{firstIndex}-{lastIndex}.txt'.format(firstIndex=j, lastIndex=j+9),'a')
    f.write(st)
    f.write(webpage)
    f.close()

def createDownThread(link,i):
    download_thread = threading.Thread(target=downloadThisURL, args=(link,i))
    download_thread.start()

def startThreads(urls):
    for url in urls:
        #for k in range(N):
        #    createDownThread(url,i)
        print(url)
        downloadThisURL(url, i)
        i+=1

def main():
    os.chdir('Webpages')
    files = glob.glob('*.txt')
    for filename in files :
        os.remove(filename)
    os.chdir('..')
    
    file = open('urls.txt', 'r')
    urls = file.readlines()
    global i
    i=0
    
    N={1,2,4,8,12,16,20,32,64}
    N=2


main()

    
