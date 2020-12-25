import urllib.request as gimme
import os, glob
import threading

def knowWhereToGo(i):       # Didn't know how else to index the files
    i = i/10
    i = int(i)
    i=i*10
    return i

def downloadThisURL(url, i, arg,N):
    j = knowWhereToGo(i)
    try:
        fid = gimme.urlopen(url)
        webpage = str(fid.read())
    except:
        webpage = "Trouble connecting to Server. Sorry for the inconvinience..."
        
    s = "\n--------------------------------------------------------------------\n"
    st = s+'\n{i}.\t'.format(i=i)+url+'\nThread who wrote this {thread}'.format(thread=arg)+s
    
    f = open('./webpages_with_{n}_threads/pages{firstIndex}-{lastIndex}.txt'.format(n=N, firstIndex=j, lastIndex=j+9),'a')
    f.write(st)
    f.write(webpage)
    f.close()
    print('Writing in webpages_with_{n}_threads'.format(n=N) )
    print('num of link = ',i,'\tnum of thread = ',arg,'\tthis url: ',url)

def createDownThread(link,i,threadIndex, N):
    download_thread = threading.Thread(target=downloadThisURL, args=(link,i,threadIndex, N))
    return download_thread


def main(N):
    os.chdir('./webpages_with_{n}_threads'.format(n=N))
    files = glob.glob('*.txt')
    for filename in files :
        os.remove(filename)
    os.chdir('..')
    
    file = open('urls.txt', 'r')
    urls = file.readlines()
    i=0
    
    th = []
    threadIndex=0
    
    for k in range(N):
        th.append(createDownThread)
        
    
    for url in urls:
        th[threadIndex](url,i,threadIndex, N).start()
        #downloadThisURL(url, i)
        i+=1
        if (threadIndex==N-1):
            threadIndex=0
        else:
            threadIndex+=1
            
            
N={1,2,4,8,12,16,20,32,64}  

for n in N:
    if not os.path.exists('./webpages_with_{n}_threads'.format(n=n)):
        os.mkdir('./webpages_with_{n}_threads'.format(n=n))
    main(n)
