# 读取文本并将拓扑关系保存到列表
#-------------------------------
f = open("edges.txt")  # 返回一个文件对象
line = f.readline()  # 调用文件的 readline()方法
a=''
r=[]
while line:
    if(len(line)==1):
        a=a[:-1]
        r.append(a)
        a = ''
    else:
        a+=line.split('=')[1]
    line = f.readline()
f.close()
#-------------------------------


#-------------------------------
