package com.data_Structure.linear_list;

/**
 * @Auther: 李爽
 * @Date: 2018/12/23 13:54
 * @Description: 线性表中出现序号越界时抛出该异常
 */
public class OutOfBoundaryExcepton extends RuntimeException {
    public OutOfBoundaryExcepton(String err){
        super(err);
    }
}
