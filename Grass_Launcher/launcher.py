from tkinter import *
from tkinter import  filedialog
from tkinter.messagebox import *
import DBO as DB
import threading
import os

fn = 'ss'

def callback():
    global fn
    filename = filedialog.askopenfilename()
    if(filename[-5:] == ".pcap"):
        fn = filename
    else:
        showinfo("提示","请打开pcap格式的文件")

def create_tables():
    dbo = DB.DBO()
    dbo.create_table(e.get())
    dbo.close()

def delete_tables():
    dbo = DB.DBO()
    dbo.delete_table(e.get())
    dbo.close()

def thread_start():
    global fn
    thread = threading.Thread(target=grass,args=(fn,e.get()))
    thread.start()

def grass(fn,tab):
    if(fn != '' and tab != ''):
        cmd = ".\grass\java_Grass\jdk8\\bin\java -classpath .;.\java_Grass\jdk8\lib\dt.jar;.\java_Grass\jdk8\lib\\tools.jar; -jar grass\GrassMarlin.jar C:\\Users\DELL\Desktop\\1.pcap "+tab
        os.system(cmd)

root = Tk()
root.title("Launcher Window")
root.geometry("800x600")
root.resizable(False,False)
Button(root,text="打开PCAP文件",command = callback).pack()
e =Entry(root)            #输入框赋值在e变量
e.pack(padx =20,pady =20) #输入框的位置设定
Button(root,text="创建",command = create_tables).pack()
Button(root,text="删除",command = delete_tables).pack()
Button(root,text="GRASS",command = thread_start).pack()

mainloop()