package core.document;

import com.sun.javafx.collections.ObservableListWrapper;
import util.Cidr;

import java.util.concurrent.CopyOnWriteArrayList;

public class CidrList extends ObservableListWrapper<Cidr> {

/*
 д��ʱ���ƣ�CopyOnWrite�����COW��˼���Ǽ����������������е�һ���Ż����ԡ�
 �����˼���ǣ�����ж�������ߣ�Callers��ͬʱҪ����ͬ����Դ�����ڴ�����Ǵ�
 ���ϵ����ݴ洢�������ǻṲͬ��ȡ��ͬ��ָ��ָ����ͬ����Դ��ֱ��ĳ����������ͼ
 �޸���Դ����ʱ��ϵͳ�Ż���������һ��ר�ø�����private copy�����õ����ߣ�����
 �����������������������Դ��Ȼ���ֲ��䡣����̶������ĵ����߶���͸���ģ�transparently����
 ��������Ҫ���ŵ������������û���޸���Դ���Ͳ����и�����private copy����������
 ��˶��������ֻ�Ƕ�ȡ����ʱ���Թ���ͬһ����Դ��
 */
    public CidrList() {
        super(new CopyOnWriteArrayList<>());
    }

    @Override
    public void add(int index, Cidr element) {
        if(element == null) {
            return;
        }

        for(Cidr cidr : this) {
            if(cidr.overlaps(element)) {
                return;
            }
        } //������ظ��ģ��Ͷ���

        super.add(index, element);
    }
}
