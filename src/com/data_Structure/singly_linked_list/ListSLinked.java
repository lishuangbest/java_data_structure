package com.data_Structure.singly_linked_list;

import com.data_Structure.linear_list.DefaultStrategy;
import com.data_Structure.linear_list.List;
import com.data_Structure.linear_list.OutOfBoundaryExcepton;
import com.data_Structure.linear_list.Strategy;

/**
 * @Auther: 李爽
 * @Date: 2018/12/25 08:30
 * @Description:
 */
public class ListSLinked implements List {
    private Strategy strategy;  //数据元素比较策略
    private SLNode head;        //单链表首结点引用
    private int size;           //线性表中数据元素的个数

    public ListSLinked(){
        this(new DefaultStrategy());
    }

    public ListSLinked(Strategy strategy){
        this.strategy = strategy;
        head = new SLNode();
        size = 0;
    }

    //辅助方法：获取数据元素e所在结点的前驱结点
    private SLNode getPreNode(Object e){
        SLNode p = head;
        while (p.getNext()!=null){
            if (strategy.equal(p.getNext().getData(),e)){
                return p;
            }else {
                p = p.getNext();
            }
        }
        return null;
    }

    //辅助方法：获取序号为0<=i<size的元素所在结点的前驱结点
    private SLNode getPreNode(int i){
        SLNode p = head;
        for (;i>0;i--){
            p = p.getNext();
        }
        return p;
    }

    //获取序号为0<=i<size的元素所在的结点
    private SLNode getNode(int i){
        SLNode p = head.getNext();
        for (;i>0;i--){
            p = p.getNext();
        }
        return p;
    }

    //返回线性表的大小，即数据元素的个数
    @Override
    public int getSize() {
        return size;
    }

    //如果线性表为空返回true，否则返回false
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    //判断线性表是否包含数据元素e
    @Override
    public boolean contains(Object e) {
        SLNode p = head.getNext();
        while (p!=null){
            if (strategy.equal(p.getData(),e)){
                return true;
            }else {
                p = p.getNext();
            }
        }
        return false;
    }

    //返回数据元素e在线性表中的序号
    @Override
    public int indexOf(Object e) {
        SLNode p = head.getNext();
        int index = 0;
        while (p!=null){
            if (strategy.equal(p.getData(),e)){
                return index;
            }else {
                index++;
                p = p.getNext();
            }
        }
        return -1;
    }

    //将数据元素e插入到线性表中i号位置
    @Override
    public void insert(int i, Object e) throws OutOfBoundaryExcepton {
        if(i<0||i>size){
            throw new OutOfBoundaryExcepton("错误，指定的插入序号越界");
        }
        SLNode p = getPreNode(i);
        SLNode q = new SLNode(e,p.getNext());
        p.setNext(q);
        size++;
        return;
    }

    //将数据元素e插入到元素obj之前
    @Override
    public boolean insertBefore(Object obj, Object e) {
        SLNode p = getPreNode(obj);
        if (p!=null){
            SLNode q = new SLNode(e,p.getNext());
            p.setNext(q);
            size++;
            return true;
        }
        return false;
    }

    //将数据元素e插入到元素obj之后
    @Override
    public boolean insertAfter(Object obj, Object e) {
        SLNode p = head.getNext();
        while (p!=null){
            if (strategy.equal(p.getData(),obj)){
                SLNode q = new SLNode(e,p.getNext());
                p.setNext(q);
                size++;
                return true;
            }else {
                p = p.getNext();
            }
        }
        return false;
    }

    //删除线性表中序号为i的元素，并返回之
    @Override
    public Object remove(int i) throws OutOfBoundaryExcepton {
        if (i<0||i>size){
            throw new OutOfBoundaryExcepton("错误，指定的删除序号越界");
        }
        SLNode p = getPreNode(i);
        Object obj = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        size--;
        return obj;
    }

    //删除线性表中第一个与e相同的元素
    @Override
    public boolean remove(Object e) {
        SLNode p = getPreNode(e);
        if (p!=null){
            p.setNext(p.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    //替换线性表中序号为i的数据元素为e，返回原数据元素
    @Override
    public Object replace(int i, Object e) throws OutOfBoundaryExcepton {
        if (i<0||i>size){
            throw new OutOfBoundaryExcepton("错误，指定的序号越界。");
        }
        SLNode p = getNode(i);
        Object obj = p.getData();
        p.setData(e);
        return obj;
    }

    //返回线性表中序号为i的数据元素
    @Override
    public Object get(int i) throws OutOfBoundaryExcepton {
        if(i<0||i>=size){
            throw new OutOfBoundaryExcepton("错误，指定的序号越界。");
        }
        SLNode p = getNode(i);
        return p.getData();
    }
}