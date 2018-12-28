package com.data_Structure.stack;

import com.data_Structure.singly_linked_list.SLNode;

/**
 * @Auther: 李爽
 * @Date: 2018/12/26 16:01
 * @Description: 堆栈的链式存储实现
 */
public class StackSLinked implements Stack{
    private SLNode top;  //链表首结点引用
    private int size;    //栈的大小
    public StackSLinked(){
        top = null;
        size = 0;
    }

    //返回堆栈的大小
    @Override
    public int getSize() {
        return size;
    }

    //判断堆栈是否为空
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    //数据元素e入栈
    @Override
    public void push(Object e) {
        SLNode q = new SLNode(e,top);
        top = q;
        size++;
    }

    //栈顶元素出栈
    @Override
    public Object pop() throws StackEmptyException {
        if (size<1){
            throw new StackEmptyException("错误，堆栈为空");
        }
        Object obj = top.getData();
        top = top.getNext();
        size--;
        return obj;
    }

    //取栈顶元素
    @Override
    public Object peek() throws StackEmptyException {
        if (size<1){
            throw new StackEmptyException("错误，堆栈为空。");
        }
        return top.getData();
    }
}