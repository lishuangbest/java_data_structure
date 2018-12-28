package com.data_Structure.linked_list;

import com.data_Structure.linear_list.OutOfBoundaryExcepton;
import com.data_Structure.singly_linked_list.Node;

/**
 * @Auther: 李爽
 * @Date: 2018/12/25 20:40
 * @Description:
 */
public class LinkedListIterator implements Iterator {
    private LinkedList list;//链接表
    private Node current;//当前结点

    //构造方法
    public LinkedListIterator(LinkedList list){
        this.list = list;
        if (list.isEmpty()){ //若列表为空
            current = null; //则当前元素置空
        }else {
            current = list.first(); //否则从第一个元素开始
        }
    }

    //移动到第一个元素
    @Override
    public void first() {
        if (list.isEmpty()){ //若列表为空
            current = null; //则当前元素置空
        }else {
            current = list.first(); //否则从第一个元素开始
        }
    }

    //移动到下一个元素
    @Override
    public void next() {
        if (isDone()){
            throw new OutOfBoundaryExcepton("错误：已经没有元素。");
        }
        if (current==list.last()){
            current = null;//当前元素后面没有更多元素
        }else {
            current = list.getNext(current);
        }
    }

    //检查迭代器中是否还有剩余的元素
    @Override
    public boolean isDone() {
        return current==null;
    }

    //返回当前元素
    @Override
    public Object currentItem() {
        if (isDone()){
            throw new OutOfBoundaryExcepton("错误：已经没有元素。");
        }
        return current.getData();
    }
}
