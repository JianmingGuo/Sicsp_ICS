import pymysql
import editable_table.utils.DBO as DB
device = "cza_device"
edges = "cza_edges"

class ToM:
    #连接数据库操作
    def __init__(self):
        self.dbo = DB.DBO()

    def Gettup(self):
        sql = "select * from "+edges+";"
        rs = self.dbo.GetSItems(sql)
        list = []
        for i1 in rs:
            if i1[2] == '6':
                try:
                    list.append((self.dbo.ip_name[i1[0]],self.dbo.ip_name[i1[1]]))
                except:
                    pass
        return list

    def GenM(self,tup):
        '''
        用tuple形成hacl
        关于读写权限，这里直接用一个列表来维护
        WF = [(0, 6), (3, 6), (6, 7), (11, 7), (15, 9), (16, 9)]  # (client,server)
        RF = [(4, 6), (12, 7), (17, 9), (19, 9), (21, 9)]
        target = ["station0", "station5", "station12", "station17"]
        '''
        list = self.dbo.GetAllItems()
        weblist = self.dbo.GetSItems("select NICKNAME from "+device+" where `NA` = 'Y';")
        filelist = self.dbo.GetSItems("select NICKNAME,WR,RR from "+device+" where `FS` = 'Y';")
        filedic = {}
        for i1 in filelist:
            filedic[i1[0]] = i1[1:3]

        with open("input.P", "w") as f2:
            f2.write("attackerLocated(internet).\n")
            for i1 in list:
                f2.write("attackGoal(execCode(" + i1[12] + ", _)).\n")

            for i1 in weblist:
                f2.write("hacl(internet, "+i1[0]+", tcp, 80).\n")
                f2.write("networkServiceInfo("+i1[0]+", _, tcp, 80, _).\n")

            for i1 in tup:
                f2.write("hacl(" + i1[0] + ", " + i1[1] + ", tcp, 80).\n")

            for i1 in list:
                if i1[4] != '':
                    cves = i1[4].split(",")[:-1]
                    name = i1[12]
                    f2.write(self.vul(name, cves))

            for i1 in filedic.keys():
                f2.write("networkServiceInfo(" + i1 + ", mountd, rpc, _, _).\n")
                for i2 in filedic[i1][0].split(","):
                    if(i2 != ''):
                        client = "station" + i2
                        f2.write("nfsExportInfo(" + i1 + ", '/export', write, " + client + ").\n")
                f2.write("localFileProtection(" + i1 + ", root, _, _).\n")
                for i2 in filedic[i1][1].split(","):
                    if(i2 != ''):
                        f2.write("nfsMounted(" + "station" + i2 + ", '/usr/local/share', " + i1 + ", '/export', read).\n")

            self.dbo.close()

    def vul(self,name,cves):
        # vulExists(webServer, 'CAN-2002-0392', httpd).
        # vulProperty('CAN-2002-0392', remoteExploit, privEscalation).
        string = ""
        tmp = list(self.dbo.GetSItems("select EXPLOIT,TOPO from "+device+" where NICKNAME = '" + name + "'")[0])
        tmp[0] = tmp[0].split(",")[:-1]
        tmp[1] = tmp[1].split(",")[:-1]
        if(cves != None):
            for i1 in range(len(cves)):
                string += "vulExists("+name+", '"+cves[i1]+"', _).\n"
                string += "vulProperty('"+cves[i1]+"', "+tmp[0][i1]+", privEscalation).\n"
        return string