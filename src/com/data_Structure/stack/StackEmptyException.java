package com.data_Structure.stack;

/**
 * @Auther: 李爽
 * @Date: 2018/12/26 10:03
 * @Description: 堆栈为空时出栈或取栈顶元素抛出此异常
 */
public class StackEmptyException extends RuntimeException {
    public StackEmptyException(String err){
        super(err);
    }
}
