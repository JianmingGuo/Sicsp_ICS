import pymysql

class CNVD:
    #连接数据库操作
    def __init__(self):
        self.conn = pymysql.connect(host='39.100.88.210', user='mulval', password='mulval', database='cnvd', charset='utf8')
        self.cursor = self.conn.cursor()  # 执行完毕返回的结果集默认以元组显示
        self.rs = ()
        self.dic = {}

    def Getcveid(self,model):
        cve = ''
        # cmd = "select cveid from CNVD where impact like '%" + model + "%';"
        cmd = "select cveid from CNVD where impact like '%" + model + "%';"
        self.cursor.execute(cmd)
        self.rs = self.cursor.fetchall()
        for i in self.rs:
            cve += i[0]+","
        return cve

    def Get_Rng_Property(self,list):
        rngs = ''
        properties = ''
        for i1 in list:
            self.cursor.execute("select vulrange,vulproperty from CNVD where cveid = '"+i1+"';")
            rs = self.cursor.fetchall()[0]
            if rs[0] == '':
                rngs += '_,'
            else:rngs += rs[0]+','
            if rs[1] == '':
                properties += '_,'
            else:properties += rs[1]+','
        return (rngs,properties)




    def close(self):
        self.cursor.close() # 关闭光标对象
        self.conn.close() # 关闭数据库连接

# n = "ABB eSOMS <=6.0.2"
# cmd = "select cveid from CNVD where impact like '%"+n+"%';"
# a = CNVD()
# print(a.Getcveid(n))

