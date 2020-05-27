package core.document;

import com.sun.javafx.collections.ObservableListWrapper;
import util.Cidr;

import java.util.concurrent.CopyOnWriteArrayList;

public class CidrList extends ObservableListWrapper<Cidr> {

/*
 写入时复制（CopyOnWrite，简称COW）思想是计算机程序设计领域中的一种优化策略。
 其核心思想是，如果有多个调用者（Callers）同时要求相同的资源（如内存或者是磁
 盘上的数据存储），他们会共同获取相同的指针指向相同的资源，直到某个调用者视图
 修改资源内容时，系统才会真正复制一份专用副本（private copy）给该调用者，而其
 他调用者所见到的最初的资源仍然保持不变。这过程对其他的调用者都是透明的（transparently）。
 此做法主要的优点是如果调用者没有修改资源，就不会有副本（private copy）被创建，
 因此多个调用者只是读取操作时可以共享同一份资源。
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
        } //如果有重复的，就丢掉

        super.add(index, element);
    }
}
