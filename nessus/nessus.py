import os

def nessus(path):
    filename=os.path.basename(path)

    _path='/root/ICS/mulval/testcases/nessus/'
    name,a=filename.split('.')
    des_path=_path+name
    dir_path=des_path

    i=1

    while (os.path.exists(dir_path)):
        dir_path = des_path + '_' + str(i)
        i = i + 1

    print(dir_path)

    cmd = 'mkdir' + ' ' + dir_path
    os.system(cmd)

    get_config(dir_path)

    cmd='cp %s %s' % (path,dir_path)
    os.system(cmd)


    # cmd='cd %s'%(dir_path)
    # os.system(cmd)

    os.chdir(dir_path)

    print(os.getcwd())

    cmd = 'nessus_translate.sh' + ' ' + filename
    print(cmd)
    os.system(cmd)

def get_config(dir_path):
    fullpath=dir_path+'/config'+'.txt'
    file=open(fullpath,'w')
    msg='jdbc:mysql://39.100.88.210:3306/nvd\nmulval\nmulval\n'

    file.write(msg)

a='/root/ICS/mulval/testcases/nessus/example.nessus'
nessus(a)