import pymysql

class DBO:

    def __init__(self):
        self.conn = pymysql.connect(host='39.100.88.210', user='mulval', password='mulval', database='grass', charset='utf8')
        self.cursor = self.conn.cursor()  # 执行完毕返回的结果集默认以元组显示
        self.rs = ()
        self.dic = {}


    def create_table(self,tab):
        tab_name = tab+"_device"
        self.cursor.execute("CREATE TABLE `"+tab_name+"` (\
                            `MAC` varchar(200) NOT NULL,\
                            `IP` varchar(20) DEFAULT NULL,\
                            `MODEL` varchar(200) DEFAULT NULL,\
                            `SERVICE` varchar(200) DEFAULT NULL,\
                            `CVE` varchar(200) DEFAULT NULL,\
                            `CNVD` varchar(200) DEFAULT NULL,\
                            `CVSS` int(11) DEFAULT NULL,\
                            `EXPLOIT` varchar(2000) DEFAULT NULL,\
                            `MANUFACTURER` varchar(200) DEFAULT NULL,\
                            `TOPO` varchar(2000) DEFAULT NULL,\
                            `NA` varchar(20) DEFAULT NULL,\
                            `FS` varchar(20) DEFAULT NULL,\
                            `NICKNAME` varchar(200) DEFAULT NULL,\
                            `OTHERIP` varchar(10000) DEFAULT '',\
                            `WR` varchar(200) DEFAULT NULL,\
                            `RR` varchar(200) DEFAULT NULL,\
                            PRIMARY KEY (`MAC`)\
                            ) ENGINE=InnoDB DEFAULT CHARSET=latin1")
        tab_name = tab+"_edges"
        self.cursor.execute("CREATE TABLE `"+tab_name+"` (\
                          `Src` varchar(100) NOT NULL,\
                          `Dest` varchar(100) NOT NULL,\
                          `Proto` varchar(100) NOT NULL,\
                          PRIMARY KEY (`Src`,`Dest`,`Proto`)\
                        ) ENGINE=InnoDB DEFAULT CHARSET=latin1")
        self.conn.commit()

    def delete_table(self,tab):
        self.cursor.execute("drop table "+tab+"_device")
        self.cursor.execute("drop table "+tab+"_edges")
        self.conn.commit()

    def close(self):
        self.cursor.close() # 关闭光标对象
        self.conn.close() # 关闭数据库连接



