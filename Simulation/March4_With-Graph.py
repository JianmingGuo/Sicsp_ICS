#!/usr/bin/python
# -*- coding:utf-8 -*-
#Author : 517021910668 董弈伯 from SJTU

#ls(IP())
#help()
import sys
import struct
from scapy.layers.inet import *
from scapy.all import *
import scapy
import threading
from time import sleep,ctime
import tkinter as tk
from tkinter import  *
import networkx as nx
import matplotlib.pyplot as plt
# import ctypes
# import inspect


###########################################################################
""" 功能调试 """
""" 发送特定IP的数据包 """
# data = struct.pack('=BHI',0x12,20,1000)
# pkt = IP(src='192.168.43.111', dst='192.168.43.88')/TCP(sport = 502 , dport = 502)/data
# send(pkt,inter=1,count=20)

""" 16进制显示包  """
# MODBUS = struct.pack('=BHI',0X12,20,1000)
# a = Ether()/IP(src='192.168.43.111', dst='192.168.43.88')/TCP()/MODBUS
# hexdump(a)


""" 发送并期待回复 """
# p = sr(IP(dst="192.168.1.1")/TCP(sport=RandShort(),dport=[440,441,442,443],flags="S"))
# for i in p:
#     i.show()

"""发送并收到回复"""
# target = "www.baidu.com/30"
# ans,unans = sr(IP(dst = target , ttl = (4,25),id = RandShort())/TCP(flags=0x2))
# for snd,rcv in ans :
#     print (snd.ttl,rcv.src, isinstance(rcv.payload , TCP))


""" 自定义的Protocal """
# class Disney(Packet):
#     name = "DisneyPacket"
#     fields_desc = [ ShortField("mickey",5),
#                  XByteField("minnie",3) ,
#                  IntEnumField("donald" , 1 ,
#                       { 1: "happy", 2: "cool" , 3: "angry" } ) ]
#
# d = Disney(mickey = 1)
# ls(d)

#modbus:
# XBytefield : hexademical Bytefield
# Shortfield : seems to be signed short.
# IP-TCP-MODBUS/TCP-MODBUS

###############################################################################

count_of_register = 10

class Modbus_TCP(Packet):
     name = 'Modbus_TCP Packet'
     fields_desc = [
         XShortField("Transaction_Identifier",800),
         XShortField("Protocal_Identifier",0x0),#协议标识符 = 0
         XShortField("Length",0x6),# 长度字段 = 后面字节的数量
         XByteField("Unit_Identifier",0x1) #从站地址
     ]

def vlenq2str(l):
    s = []
    s.append( hex(l & 0x7F) )
    l = l >> 7
    while l>0:
        s.append( hex(0x80 | (l & 0x7F) ) )
        l = l >> 7
    s.reverse()
    return "".join(chr(int(x, 16)) for x in s)

def str2vlenq(s=""):
    i = l = 0
    while i<len(s) and ord(s[i]) & 0x80:
        l = l << 7
        l = l + (ord(s[i]) & 0x7F)
        i = i + 1
    if i == len(s):
        warning("Broken vlenq: no ending byte")
    l = l << 7
    l = l + (ord(s[i]) & 0x7F)

    return s[i+1:], l


class VarLenQField(Field):
    """ variable length quantities """
    __slots__ = ["fld"]

    def __init__(self, name, default, fld):
        Field.__init__(self, name, default)
        self.fld = fld

    def i2m(self, pkt, x):
        if x is None:
            f = pkt.get_field(self.fld)
            x = f.i2len(pkt, pkt.getfieldval(self.fld))
            x = vlenq2str(x)
        return raw(x)

    def m2i(self, pkt, x):
        if x is None:
            return None, 0
        return str2vlenq(x)[1]

    def addfield(self, pkt, s, val):
        return s+self.i2m(pkt, val)

    def getfield(self, pkt, s):
        return str2vlenq(s)

class Modbus_0x3_Query(Packet): #显然，query 和response说的不是一回事。
    name = 'Modbus Query Packet'
    fields_desc =  [
        XByteField("Function_Code",0x03),
        XShortField("Reference_Number",0x0000),
        XShortField("Word Count",0x000a)
    ]

class Modbus_0x3_Response(Packet):
    name = 'Modbus Response Packet'
    fields_desc = [
        XByteField("Function_Code",0x03),
        XByteField("Length",0x14),
        XShortField("reg0", 0x0000),
        XShortField("reg1", 0x0000),
        XShortField("reg2", 0x0000),
        XShortField("reg3", 0x0000),
        XShortField("reg4", 0x0000),
        XShortField("reg5", 0x0000),
        XShortField("reg6", 0x0000),
        XShortField("reg7", 0x0000),
        XShortField("reg8", 0x0000),
        XShortField("reg9", 0x0000),

    ]

#设备码是依赖于Ethernet的，但由于暂时缺少相关信息，所以Ethernet是暂缺的。
# p = IP(src='192.168.43.111', dst='192.168.43.88')/TCP()/Modbus_TCP(Length='6')/Modbus_Query(Function_Code = '0x03')

#千万不要给Length 加引号。8个小时的血泪教训。Pattern Matching会报错。
#千万不要给Length 加引号。8个小时的血泪教训。Pattern Matching会报错。
#千万不要给Length 加引号。8个小时的血泪教训。Pattern Matching会报错。


def _0x3_Query(times):
    Ack = 1
    Seq = 1
    transaction_identifier = 1934
    while(times > 0):
    #TCP ack & seq remains to be improved.
    #"""0x018 很重要...不然wireshark是黑的"""
        p = IP( src='192.168.43.111', dst='192.168.43.88')/\
            TCP(sport = 57145,dport = 502,seq=Seq,ack=Ack,flags=0x018)/\
            Modbus_TCP(Length=6,Transaction_Identifier= (transaction_identifier))/\
            Modbus_0x3_Query(Function_Code = 0x03)
        transaction_identifier += 1
        Ack = Ack + 29
        Seq = Seq + 12
        send(p,inter = 1,count =1)
        times =times - 1

# _0x3_Query(5)

def _0x3_Response(times):
    Ack = 13
    Seq = 1
    transaction_identifier = 1935
    while(times > 0):
        p = IP( src='192.168.43.88', dst='192.168.43.111')/\
            TCP(sport = 502,dport = 57145,seq=Seq,ack=Ack,flags=0x018)/\
            Modbus_TCP(Length=23,Transaction_Identifier= (transaction_identifier))/\
            Modbus_0x3_Response(Function_Code = 0x03)
        transaction_identifier += 1
        Ack = Ack + 12
        Seq = Seq + 29
        send(p,inter = 1,count =1)
        times =times - 1


flag = True
def _0x3_communicate(ip_src,ip_dst):
    """
    mixed function_call with query and response
    :param ip_src: source ip
    :param ip_dst: destination ip
    :return: null
    """
    global flag
    Ack1 = 1
    Seq1 = 1
    Ack2 = 13
    Seq2 = 1
    transaction_identifier = 1934
    while(flag):
        p = IP( src=ip_src, dst=ip_dst)/\
            TCP(sport = 57145,dport = 502,seq=Seq1,ack=Ack1,flags=0x018)/\
            Modbus_TCP(Length=6,Transaction_Identifier= (transaction_identifier))/\
            Modbus_0x3_Query(Function_Code = 0x03)
        send(p,count =1)
        q = IP( src=ip_dst, dst=ip_src)/\
            TCP(sport = 502,dport = 57145,seq=Seq2,ack=Ack2,flags=0x018)/\
            Modbus_TCP(Length=23,Transaction_Identifier= (transaction_identifier))/\
            Modbus_0x3_Response(Function_Code = 0x03)
        send(q,count=1)
        r = IP( src=ip_src, dst=ip_dst)/\
            TCP(sport = 57145,dport = 502,seq=Seq1+12,ack=Ack1+20,flags=0x010)
        send(r,count=1)
        transaction_identifier += 1
        Ack1 = Ack1 + 29
        Seq1 = Seq1 + 12
        Ack2 = Ack2 + 12
        Seq2 = Seq2 + 29
        sleep(1)

#_0x3_communicate('192.168.43.111','192.168.43.88')


# Test example
# thread2 = threading.Thread(target = _0x3_communicate,args=('192.168.43.112','192.168.43.88'))
# # print('遠坂凛大好き')
# thread1 = threading.Thread(target = _0x3_communicate,args=('192.168.43.111','192.168.43.88'))
# thread3 = threading.Thread(target = _0x3_communicate,args=('192.168.43.113','192.168.43.88'))
# thread4 = threading.Thread(target = _0x3_communicate,args=('192.168.43.114','192.168.43.88'))
# thread2.start()
# thread1.start()
# thread3.start()
# thread4.start()
# thread5 = threading.Thread(target = _0x3_communicate,args=('11.168.43.113','11.168.43.88'))
# thread6 = threading.Thread(target = _0x3_communicate,args=('11.168.43.114','11.168.43.88'))
# thread5.start()
# thread6.start()

root = tk.Tk()
root.geometry('{}x{}+{}+{}'.format(600,400, 250, 350))
root.title('modbus 发包器_ function_code = 0x3')

src_text = tk.Label(text='src ip ↓')
src_text.pack()
src_input = tk.Entry()
src_input.pack()
dst_text = tk.Label(text='dst ip ↓')
dst_text.pack()
dst_input = tk.Entry()
dst_input.pack()

ip_List = []
comm_List =[]
def Create_Button_Fun():
    """
    port is stationary at present.
    structure is not checked.
    :return:
    """
    global ip_List,Existing_List
    src = src_input.get()
    dst = dst_input.get()
    if(src,dst) in comm_List:
        print("already exists")
        return
    else:
        new_thread_name = str(src)+ " <->>> "+str(dst)
        new_thread = threading.Thread(name =new_thread_name,target = _0x3_communicate,args=(src,dst))
        new_thread.start()
    if src not in ip_List:
        ip_List.append(src)
    if dst not in ip_List:
        ip_List.append(dst)
    comm_List.append((src,dst))
    Existing_List.insert(END,new_thread_name)

Send_Button = tk.Button(text = "Create Communication!",
                        command = Create_Button_Fun
                       )
Send_Button.pack()

Existing_List = tk.Listbox(root,selectmode = SINGLE,width =40)
Existing_List.pack()



# def _async_raise(tid, exctype):
#     """raises the exception, performs cleanup if needed"""
#     tid = ctypes.c_long(tid)
#     if not inspect.isclass(exctype):
#         exctype = type(exctype)
#     res = ctypes.pythonapi.PyThreadState_SetAsyncExc(tid, ctypes.py_object(exctype))
#     if res == 0:
#         raise ValueError("invalid thread id")
#     elif res != 1:
#         # """if it returns a number greater than one, you're in trouble,
#         # and you should call it again with exc=NULL to revert the effect"""
#         ctypes.pythonapi.PyThreadState_SetAsyncExc(tid, None)
#         raise SystemError("PyThreadState_SetAsyncExc failed")
#
#
# def stop_thread(thread):
#     _async_raise(thread.ident, SystemExit)


# def stop_communication():
#     global Existing_List
#     index = Existing_List.curselection()
#     threading_name = Existing_List.get(first = index[0] )
#     t = threading_List.find(threading_name)
#     t.stop() this doesn't work
#
# Delete_Button = tk.Button(command = stop_communication)
# Delete_Button.pack()




def draw():
    global ip_List
    G = nx.MultiGraph()
    G.add_nodes_from(ip_List)
    G.add_edges_from(comm_List)
    nx.draw(G,with_labels=True)
    plt.show()

Draw_Button = tk.Button(command = draw,text = "Print Graph")
Draw_Button.pack()

root.mainloop()