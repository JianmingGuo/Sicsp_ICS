import xlrd

file='cve.xls'
data=xlrd.open_workbook(file)
table=data.sheets()[0]
impact=table.col_values(5)
cve=table.col_values(7)
cvss=table.col_values(19)
av=table.col_values(20)


desti=input("请输入机型：")
# desti='WAGO PFC200'
s=[s for s in impact if desti in s]

li=[]
for i in s:
    li.append(impact.index(i))

source=list(set(li))

le=1
for i in source:

    print("第 %d 个匹配到的漏洞 :"%(le) )
    print("cve:",cve[i],"\ncvss:",cvss[i],"\tav:",av[i][3],"\tac:",av[i][8],"\tau:",av[i][13],"\tC:",av[i][17],'\tI:',av[i][21],'A:',av[i][25])
    le=le+1