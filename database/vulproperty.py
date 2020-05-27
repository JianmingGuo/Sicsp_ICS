import xlrd
import xlwt

file='nvd1.xls'

data=xlrd.open_workbook(file)
table=data.sheets()[0]
cveid=table.col_values(0)
desci=table.col_values(1)
cvss2=table.col_values(3)
cvss3=table.col_values(5)


len=cveid.__len__()


workbook=xlwt.Workbook(encoding='utf-8')
test=workbook.add_sheet('test')


for i in range(0,len):

    conse=[]
    exploit_range=''

    if (cvss3[i]!='' and cvss3[i]!=1):
        if (cvss3[i][12]=='N'):
            exploit_range='remoteExploit'
        else:
            exploit_range='localExploit'

        if(cvss3[i][31]=='C'):
            conse.append('privilege escalation  ')
        else:
            if 'privilege' in desci[i] and 'escala' in desci[i]:
                conse.append('privilege escalation  ')

        if(cvss3[i][35]=='H'):
            conse.append('confidentiality loss  ')
        if(cvss3[i][39]=='H'):
            conse.append('integrity loss  ')
        if 'denial' in desci[i]:
            conse.append('denial of service')

    else:
        if (cvss2[i] != '' and cvss2[i] != 1):
            if(cvss2[i][4]=='N'):
                exploit_range='remoteExploit'
            else:
                exploit_range='localExploit'

            if(cvss2[i][18]=='C'):
                conse.append('confidentiality loss  ')
            if(cvss2[i][22]=='C'):
                conse.append('integrity loss  ')
            if 'denial' in desci[i]:
                conse.append('denial of service')
            if 'privilege' in desci[i] and 'escala' in desci[i]:
                conse.append('privilege escalation  ')

    test.write(i,0,cveid[i])
    test.write(i,1,exploit_range)
    test.write(i,2,conse)

workbook.save('vulproperty.xls')