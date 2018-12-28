package com.data_Structure.stack;

/**
 * @Auther: 李爽
 * @Date: 2018/12/26 14:59
 * @Description: Stack的顺序存储实现
 */
public class StackArray implements Stack{
    private final int LEN = 8; //数组的默认大小
    private Object[] elements; //数据元素数组
    private int top;           //栈顶指针

    public StackArray(){
        top = -1;
        elements = new Object[LEN];
    }

    //返回堆栈的大小
    @Override
    public int getSize() {
        return top+1;
    }

    //返回堆栈是否为空
    @Override
    public boolean isEmpty() {
        return top<0;
    }

    //数据元素e入栈
    @Override
    public void push(Object e) {
        if (getSize()>=elements.length){
            expandSpace();
        }
        elements[++top] = e;
    }

    private void expandSpace(){
        Object[] a = new Object[elements.length*2];
        for (int i = 0; i < elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }

    //栈顶元素出栈
    @Override
    public Object pop() throws StackEmptyException {
        if (getSize()<1){
            throw new StackEmptyException("错误，堆栈为空。");
        }
        Object obj = elements[top];
        elements[top--] = null;
        return obj;
    }

    //取栈顶元素
    @Override
    public Object peek() throws StackEmptyException {
        if (getSize()<1){
            throw new StackEmptyException("错误，堆栈为空。");
        }
        return elements[top];
    }
}