import xlrd
import xlwt
from lxml import etree
from selenium import webdriver
import time
import random

chrome = webdriver.PhantomJS(executable_path="D:\\software\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe")
webdriver.PhantomJS()

def get_info(id):
    start_url = 'https://nvd.nist.gov/vuln/detail/'

    url = '{}{}'.format(start_url, id)  # url拼接


    chrome.get(url)
    result = chrome.page_source
    html = etree.HTML(result)

    # result=requests.get(url,headers=headers)
    path_title = '//*[@id="p_lt_WebPartZone1_zoneCenter_pageplaceholder_p_lt_WebPartZone1_zoneCenter_VulnerabilityDetail_VulnFormView"]/tbody/tr/td/h2/span'
    path_descrip = '//*[@id="p_lt_WebPartZone1_zoneCenter_pageplaceholder_p_lt_WebPartZone1_zoneCenter_VulnerabilityDetail_VulnFormView"]/tbody/tr/td/div/div[1]/p[1]/text()'
    path_cvss3 = '//*[@id="p_lt_WebPartZone1_zoneCenter_pageplaceholder_p_lt_WebPartZone1_zoneCenter_VulnerabilityDetail_VulnFormView_Vuln3CvssPanel"]/div/div[3]/span/span'
    path_base = '//*[@id="p_lt_WebPartZone1_zoneCenter_pageplaceholder_p_lt_WebPartZone1_zoneCenter_VulnerabilityDetail_VulnFormView_Cvss3NistCalculatorAnchor"]'

    path_base2 = '//*[@id="p_lt_WebPartZone1_zoneCenter_pageplaceholder_p_lt_WebPartZone1_zoneCenter_VulnerabilityDetail_VulnFormView_Cvss2CalculatorAnchor"]'
    path_cvss2 = '//*[@id="p_lt_WebPartZone1_zoneCenter_pageplaceholder_p_lt_WebPartZone1_zoneCenter_VulnerabilityDetail_VulnFormView_Vuln2CvssPanel"]/div/div[3]/span/span'
    if (html.xpath(path_title) == []):
        return 1, 1, 1, 1, 1
    title = html.xpath(path_title)[0].text
    description = html.xpath(path_descrip)[0]



    if(html.xpath(path_base2)==[]):
        base2=[]
        cvss2=[]
    else:
        base2 = html.xpath(path_base2)[0].text
        cvss2 = html.xpath(path_cvss2)[0].text

    base3 = html.xpath(path_base)
    if (base3 == []):
        cvss3=[]
        basescore=[]
    else:
        cvss3 = html.xpath(path_cvss3)[0].text
        basescore = html.xpath(path_base)[0].text

    return description,base2,cvss2,cvss3,basescore

file='cve.xls'
data=xlrd.open_workbook(file)
table=data.sheets()[0]
cve=table.col_values(7)

cveid=[]
for i in cve:
    a,b=i.split(' ')
    cveid.append(a)

workbook=xlwt.Workbook(encoding='utf-8')
test=workbook.add_sheet('test')


line=-1

first=1185
len=cveid.__len__()

# for id in cveid:
for x in range(first,len):
    id=cveid[x]
    time.sleep(random.randint(1,5))
    line=line+1
    print(line,"    ",id)
    if (id==''):
        print("no id")
        continue

    else:
        description, base2, cvss2,cvss3,base3=get_info(id)

        test.write(line,0,id)
        test.write(line,1,description)
        test.write(line,2,base2)
        test.write(line,3,cvss2)
        test.write(line,4,base3)
        test.write(line,5,cvss3)
        test.write(line,6,base3)
        print(cvss2)

workbook.save('nvd.xls')