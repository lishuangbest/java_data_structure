package com.data_Structure.queue;

/**
 * @Auther: 李爽
 * @Date: 2018/12/26 16:58
 * @Description: 顺序队列
 */
public class QueueArray implements Queue{
    private static final int CAP=7;//队列默认大小
    private Object[] elements;     //数据元素数组
    private int capacity;          //数组的大小elements.length
    private int front;             //队首指针，指向队首
    private int rear;              //队尾指针，指向队尾后一个位置
    public QueueArray(){
        this(CAP);
    }

    public QueueArray(int cap){
        capacity = cap + 1;
        elements = new Object[capacity];
        front = rear = 0;
    }

    //返回队列的大小
    @Override
    public int getSize() {
        return (rear - front + capacity) % capacity;
    }

    //判断队列是否为空
    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    //数据元素e入队
    @Override
    public void enqueue(Object e) {
        if (getSize()==capacity-1){
            expandSpace();
        }
        elements[rear] = e;
        rear = (rear+1)%capacity;
    }

    private void expandSpace(){
        Object[] a = new Object[elements.length*2];
        int i = front;
        int j = 0;
        while (i!=rear){ //将从front开始到rear前一个存储单元的元素复制到新数组
            a[j++] = elements[i];
            i = (i+1)%capacity;
        }
        elements = a;
        capacity = elements.length;
        front = 0;
        rear = j; //设置新的队首、队尾指针
    }

    //队首元素出队
    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty()){
            throw new QueueEmptyException("错误：队列为空");
        }
        Object obj = elements[front];
        elements[front] = null;
        front = (front+1)%capacity;
        return obj;
    }

    //取队首元素
    @Override
    public Object peek() throws QueueEmptyException {
        if (isEmpty()){
            throw new QueueEmptyException("错误：队列为空");
        }
        return elements[front];
    }
}
