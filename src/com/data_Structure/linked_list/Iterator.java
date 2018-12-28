package com.data_Structure.linked_list;

/**
 * @Auther: 李爽
 * @Date: 2018/12/25 20:37
 * @Description: 迭代器接口
 */
public interface Iterator {
    //移动到第一个元素
    public void first();
    //移动到下一个元素
    public void next();
    //检查迭代器中是否还有剩余的元素
    public boolean isDone();
    //返回当前元素
    public Object currentItem();
}