import urllib.request as gimme

def knowWhereToGo(i):       # Didn't know how else to index the files
    i = i/10
    i = int(i)
    i=i*10
    return i

def downloadThisURL(url, i):
    j = knowWhereToGo(i)
    
    fid = gimme.urlopen(url)
    webpage = str(fid.read())
    
    s = "\n--------------------------------------------------------------------\n"
    st = s+'\n{i}.\t'.format(i=i)+url+s
    
    f = open('./Webpages/pages{firstIndex}-{lastIndex}.txt'.format(firstIndex=j, lastIndex=j+9),'a')
    f.write(st)
    f.write(webpage)
    f.close()

file = open('urls.txt', 'r')
urls = file.readlines()
i=0

for url in urls:
    print(url)
    downloadThisURL(url, i)
    i+=1




