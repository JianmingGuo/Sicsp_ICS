import requests
from urllib.parse import urlencode
from lxml import etree
import time
import xlwt
import xlrd

# url='https://ics.cnvd.org.cn/'

def pageurl(min_page,max_page):                      #获取max_page页数的url
    baseurl = 'http://ics.cnvd.org.cn/?'
    params = {
        'tdsourcetag': 's_pctim_aiomsg',
        'max': '20'
    }
    page=[]
    for i in range(min_page,max_page):
        params['offset'] = i * 20
        url = baseurl + urlencode(params)
        page.append(url)
    return page

def geturl(url):                    #获取某页的所有链接
    headers = {
        'Host': 'ics.cnvd.org.cn',
        'Referer': 'http://ics.cnvd.org.cn/?tdsourcetag=s_pctim_aiomsg&max=20&offset=40',
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36'
    }
    response = requests.get(url, headers=headers)
    html=etree.HTML(response.text)

    sin_url=[]
    for li in html.xpath('//tbody[@id="tr"]/tr'):
        x=li.xpath('td/a/@href')[0]
        sin_url.append(x)
    return sin_url

def parse_page(content, url):
    html = etree.HTML(content)
    item = {}
    item['url'] = url
    if (html.xpath('/html/body/div[4]/div[1]/div[1]/div[1]/h1')==[]):
        item['标题']=''
    else:
        item['标题'] = str(html.xpath('/html/body/div[4]/div[1]/div[1]/div[1]/h1')[0].text)

    item['CNVD_ID'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="CNVD-ID"]/following-sibling::*[1]//text()')])
    item['公开日期'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="公开日期"]/following-sibling::*[1]//text()')])
    item['危害级别'] = ''.join([i.strip().replace(' ', '').replace('\r', '').replace('\n', '').replace('\t', '') for i in
                            html.xpath('//tbody/tr/td[text()="危害级别"]/following-sibling::*[1]//text()')])
    if(html.xpath('//*[@id="showDiv"]/div')==[]):
        item['cvss']=''
    else:
        item['cvss']=''.join(html.xpath('//*[@id="showDiv"]/div')[0].text)

    if(html.xpath('/html/body/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[2]/a')==[]):
        item['av']=''
    else:
        item['av']=''.join(html.xpath('/html/body/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[2]/a')[0].text)
    item['影响产品'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="影响产品"]/following-sibling::*[1]//text()')])
    try:
        item['BUGTRAQ_ID'] = ''.join(
            [i.strip() for i in html.xpath('//tbody/tr/td[text()="BUGTRAQ ID"]/following-sibling::*[1]//text()')])
    except:
        item['BUGTRAQ_ID'] = ''
    item['CVE_ID'] = ''.join(
        [i.strip() for i in
         html.xpath('//tbody/tr/td[text()="CVE ID"]/following-sibling::*[1]//text()')]) + ' ' + ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="CVE ID"]/following-sibling::*[1]//@href')])

    item['漏洞描述'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="漏洞描述"]/following-sibling::*[1]//text()')])
    item['漏洞类型'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="漏洞类型"]/following-sibling::*[1]//text()')])
    item['参考链接'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="参考链接"]/following-sibling::*[1]//text()')])
    item['漏洞解决方案'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="漏洞解决方案"]/following-sibling::*[1]//text()')])
    item['厂商补丁'] = ''.join(
        [i.strip() for i in html.xpath(
            '//tbody/tr/td[text()="厂商补丁"]/following-sibling::*[1]//text()')]) + ' http://www.cnvd.org.cn' + ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="厂商补丁"]/following-sibling::*[1]//@href')])
    item['验证信息'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="验证信息"]/following-sibling::*[1]//text()')])
    item['报送时间'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="报送时间"]/following-sibling::*[1]//text()')])
    item['收录时间'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="收录时间"]/following-sibling::*[1]//text()')])
    item['更新时间'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="更新时间"]/following-sibling::*[1]//text()')])
    item['漏洞附件'] = ''.join(
        [i.strip() for i in html.xpath('//tbody/tr/td[text()="漏洞附件"]/following-sibling::*[1]//text()')])

    return item

import random

def get_page(url):
    headers = {
        'Host': 'www.cnvd.org.cn',
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36'
    }
    response = requests.get(url, headers=headers)
    return response.text


def get_cve():
    workbook=xlwt.Workbook(encoding='utf-8')
    test=workbook.add_sheet('test')
    line=0
    page=pageurl(100,125)    #0,5即1-5页  5，10即6-10页
    print(page)
    pa=51
    for x in page:
        time.sleep(random.randint(10,30))
        url=geturl(x)

        print("第 %d 页"%(pa))
        print(url)
        pa=pa+1

        for i in url:
            time.sleep(random.randint(3,20))
            result=get_page(i)
            item=parse_page(result,i)

            test.write(line,0,item['url'])
            test.write(line, 1, item['标题'])
            test.write(line, 2, item['CNVD_ID'])
            test.write(line, 3, item['公开日期'])
            test.write(line, 4, item['危害级别'])
            test.write(line, 5, item['影响产品'])
            test.write(line, 6, item['BUGTRAQ_ID'])
            test.write(line, 7, item['CVE_ID'])
            test.write(line, 8, item['漏洞描述'])
            test.write(line, 9, item['漏洞类型'])
            test.write(line, 10, item['参考链接'])
            test.write(line, 12, item['漏洞解决方案'])
            test.write(line, 13, item['厂商补丁'])
            test.write(line, 14, item['验证信息'])
            test.write(line, 15, item['报送时间'])
            test.write(line, 16, item['收录时间'])
            test.write(line, 17, item['更新时间'])
            test.write(line, 18, item['漏洞附件'])
            test.write(line, 19, item['cvss'])
            test.write(line, 20, item['av'])
            # test.write(line, 21, item[])
            # test.write(line, 22, item[])
            # test.write(line, 23, item[])
            line=line+1
            print("finished:",line,"标题：",item['标题'])

    workbook.save('3.xls')

def split_cve(file):

    data = xlrd.open_workbook(file)
    table = data.sheets()[0]
    cve = table.col_values(7)
    cvss = table.col_values(20)

    workbook=xlwt.Workbook(encoding='utf-8')
    test=workbook.add_sheet('test')
    line=-1

    for i in cve:
        line = line + 1
        if(i=='' or cvss[line]==''):
            continue
        else:
            cveid,url=i.split(' ')
            test.write(line,0,cveid)
            test.write(line,1,url)
            test.write(line,2,cvss[line][3])
            test.write(line,3, cvss[line][8])
            test.write(line,4, cvss[line][13])

    workbook.save('cveid.xls')

