package com.data_Structure.singly_linked_list;

/**
 * @Auther: 李爽
 * @Date: 2018/12/24 10:00
 * @Description: 单链表节点定义
 */
public class SLNode implements Node {
    private Object element;
    private SLNode next;

    public SLNode(){
        this(null,null);
    }

    public SLNode(Object ele,SLNode next){
        this.element = ele;
        this.next = next;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }



    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object obj) {
        element = obj;
    }
}