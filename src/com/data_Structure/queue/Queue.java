package com.data_Structure.queue;

/**
 * @Auther: 李爽
 * @Date: 2018/12/26 16:27
 * @Description: 队列接口
 */
public interface Queue {
    //返回队列的大小
    public int getSize();
    //判断队列是否为空
    public boolean isEmpty();
    //数据元素e入队
    public void enqueue(Object e);
    //队首元素入队
    public Object dequeue() throws QueueEmptyException;
    //取队首元素
    public Object peek() throws QueueEmptyException;
}
