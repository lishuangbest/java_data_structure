package com.data_Structure.queue;

/**
 * @Auther: 李爽
 * @Date: 2018/12/26 16:29
 * @Description: 队列为空时出队或取队首元素抛出此异常
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String err){
        super(err);
    }
}
