import datetime 

mydatetime = datetime.datetime.now()
#print("now =", mydatetime)

d1 = mydatetime.strftime("%d/%m/%Y %H:%M:%S")
print("The current date and time is :\t", d1)

due_date = datetime.datetime(2021, 6, 1)
due = due_date.strftime("%d/%m/%Y %H:%M:%S")
print("Project is on due in :\t\t\t",due)

s1 = mydatetime.timestamp()
s2 = due_date.timestamp()

s3 = s2-s1

m, s = divmod(s3, 60)
h, m = divmod(m, 60)
d, h = divmod(h, 24)

s = int(s)
m = int(m)
h = int(h)
d = int(d)

print('{d} days, {h} hours, {m} minutes and {s} seconds left'.format(d=d, h=h, m=m, s=s))
print('\nor\n')

s=int(s3)

print('in {s} seconds'.format(s=s))
print('\nor\n')

m, s = divmod(s3, 60)
m = int(m)

print('in {m} minutes'.format(m=m))
print('\nor\n')

m, s = divmod(s3, 60)
h, m = divmod(m, 60)
h = int(h)

print('in {h} hours'.format(h=h))

