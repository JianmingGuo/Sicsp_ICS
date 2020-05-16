import pymysql
import editable_table.utils.CNVD as CD
device = "cza_device"
edges = "cza_edges"

class DBO:

    def __init__(self):
        self.conn = pymysql.connect(host='39.100.88.210', user='mulval', password='mulval', database='grass', charset='utf8')
        self.cursor = self.conn.cursor()  # 执行完毕返回的结果集默认以元组显示
        self.rs = ()
        self.dic = {}
        self.ip_name = self.cast()

    def GetAllItems(self):
        sql = "select * from "+device+";"
        self.cursor.execute(sql)  # 执行SQL语句
        self.rs = self.cursor.fetchall()
        return self.rs

    def GetSItems(self,sql):
        self.cursor.execute(sql)  # 执行SQL语句
        self.rs = self.cursor.fetchall()
        return self.rs

    def delete(self,ll):
        for i1 in ll:
            cmd = "delete from "+device+" where `NICKNAME`='" + i1 + "';"
            self.cursor.execute(cmd)
            self.conn.commit()

    def RetTabEle(self):
        sql = "select * from "+device+";"
        self.cursor.execute(sql)  # 执行SQL语句
        self.rs = self.cursor.fetchall()
        for i in self.rs:
            self.dic[i[1]] = i[12]
        return self.dic

    def Infoupdate(self,ll):
        for l in ll:
            # if(l[1]=='station51'):
            #     print("haha")
            l[2]=l[2].replace("false","N")
            l[2]=l[2].replace("true","Y")
            # if (l[2][0]=='Y'):
            cmd = "update "+device+" set `NA` = '"+l[2][0]+"' where `NICKNAME` = '"+l[1]+"';"
            self.cursor.execute(cmd)
            # if (l[2][1]=='Y'):
            cmd = "update "+device+" set `FS` = '"+l[2][1]+"' where `NICKNAME` = '"+l[1]+"';"
            self.cursor.execute(cmd)
            cmd = "update "+device+" set `RR` = '"+l[3]+"' where `NICKNAME` = '" + l[1] + "';"
            self.cursor.execute(cmd)
            cmd = "update "+device+" set `WR` = '"+l[4]+"' where `NICKNAME` = '" + l[1] + "';"
            self.cursor.execute(cmd)
            cmd = "update "+device+" set `MODEL` = '"+l[5]+"' where `NICKNAME` = '" + l[1] + "';"
            self.cursor.execute(cmd)
            self.conn.commit()

    def CVEupdate(self,ll):
        cnvd = CD.CNVD()
        cve=''
        for l in ll:
            model = l[5]
            sql = "update "+device+" set `MODEL` = '" + model + "' where `NICKNAME` = '" + l[1] + "';"
            self.cursor.execute(sql)
            self.conn.commit()
            if (model != ''):
                cve = cnvd.Getcveid(model)
                if cve != '':
                    tmp = cve.split(",")[:-1]
                    rng_pro = cnvd.Get_Rng_Property(tmp)
                    self.cursor.execute("update "+device+" set `EXPLOIT` = '" + rng_pro[0] + "' where `NICKNAME` = '" + l[1] + "';")
                    self.cursor.execute("update "+device+" set `TOPO` = '" + rng_pro[1] + "' where `NICKNAME` = '" + l[1] + "';")
            else:
                self.cursor.execute(
                    "update "+device+" set `EXPLOIT` = '' where `NICKNAME` = '" + l[1] + "';")
                self.cursor.execute(
                    "update "+device+" set `TOPO` = '' where `NICKNAME` = '" + l[1] + "';")

            sql = "update "+device+" set `CVE` = '" + cve + "' where `NICKNAME` = '" + l[1] + "';"
            self.cursor.execute(sql)
            self.conn.commit()
            cve = ''
        cnvd.close()

    def cast(self):
        ips = set()
        cast = {}
        self.cursor.execute("select * from "+edges+";")
        self.rs = self.cursor.fetchall()
        for i1 in self.rs:
            ips.add(i1[0])
            ips.add(i1[1])
        self.cursor.execute("select IP,NICKNAME,OTHERIP from "+device+";")
        self.rs = self.cursor.fetchall()
        for i1 in ips:
            for i2 in self.rs:
                if(i1 == i2[0] or i2[2].find(i1)>=1):
                    cast[i1] = i2[1]
        return cast


    def close(self):
        self.cursor.close() # 关闭光标对象
        self.conn.close() # 关闭数据库连接






# a = DBO()
# b = a.GetAllItems()
# print(b)
