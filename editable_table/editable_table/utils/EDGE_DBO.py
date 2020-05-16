import pymysql

class EDGE_DBO:

    def __init__(self):
        self.conn = pymysql.connect(host='39.100.88.210', user='mulval', password='mulval', database='grass', charset='utf8')
        self.cursor = self.conn.cursor()  # 执行完毕返回的结果集默认以元组显示
        self.rs = ()
        self.dic = {}