from tkinter import *
from tkinter import  filedialog
from tkinter.messagebox import *
import DBO as DB
import threading
import os

fn = ''


def callback():
    global fn
    filename = filedialog.askopenfilename()
    pcap_path.set(filename)
    if(filename[-5:] == ".pcap"):
        fn = filename
        text.insert(END,"文件读取成功")
        text.see(END)
        text.update()
    else:
        showinfo("提示","请打开pcap格式的文件")

def create_tables():
    dbo = DB.DBO()
    text.insert(END, "正在创建表格...请稍等")
    text.see(END)
    text.update()
    flag=dbo.create_table(e.get())
    dbo.close()
    if (flag == 0):
        text.insert(END, "名称重复，请更换！！")
        text.see(END)
        text.update()

    else:
        text.insert(END, "表格创建成功！！")
        text.see(END)
        text.update()

def delete_tables():
    dbo = DB.DBO()
    text.insert(END, "正在删除表格...请稍等")
    text.see(END)
    text.update()
    flag=dbo.delete_table(e.get())
    dbo.close()

    if(flag==1):
        text.insert(END, "表格删除成功！！")
        text.see(END)
        text.update()
    else:
        text.insert(END, "数据中无此名称表格，请更换！！")
        text.see(END)
        text.update()

def thread_start():
    print('OK')
    global fn
    print('OK1')
    thread = threading.Thread(target=grass,args=(fn,e.get()))
    print('OK2')
    thread.start()

def grass(fn,tab):
    if(fn != '' and tab != ''):
        text.insert(END, "正在打开Grass_topology...请稍等")
        text.see(END)
        text.update()
        cmd = ".\grass\java_Grass\jdk8\\bin\java -classpath .;.\java_Grass\jdk8\lib\dt.jar;.\java_Grass\jdk8\lib\\tools.jar; -jar grass\GrassMarlin.jar "+fn+" "+tab
        os.system(cmd)
        text.insert(END, "打开成功！！")
        text.see(END)
        text.update()

root = Tk()
root.title("Launcher Window")
root.geometry("700x400")
root.resizable(False,False)

pcap_path=StringVar()

# photo=PhotoImage(file="lib\\1.gif")
# Label(root,image=photo).pack()


Label(root,text="Grass Launcher",font=('HGB4X_CNKI',22)).place(x=250,y=5)


Label(root,text="请选择pcap文件：",font=('微软雅黑',12)).place(x=10,y=55)
button1=Button(root,text="打开PCAP文件",command = callback)
button1.place(x=260,y=90)
entry1=Entry(root,textvariable=pcap_path,font=('微软雅黑',12),width=26)
entry1.place(x=10,y=90)

Label(root,text="请输入待操作网络名称",font=('微软雅黑',12)).place(x=10,y=140)

e =Entry(root,font=('微软雅黑',12),width=26)            #输入框赋值在e变量
# e.pack(padx =20,pady =20) #输入框的位置设定
e.place(x=10,y=180)
#
Button(root,text="为本网络创建拓扑信息",command = create_tables).place(x=230,y=220)
Button(root,text="删除本网络拓扑信息",command = delete_tables).place(x=243,y=260)
Button(root,text="Launch Grass_topology",font=('HGB4X_CNKI',15),command = thread_start).place(x=60,y=300)


text=Listbox(root,font=("微软雅黑",10),width=40,height=16)
text.place(x=370,y=70)

mainloop()