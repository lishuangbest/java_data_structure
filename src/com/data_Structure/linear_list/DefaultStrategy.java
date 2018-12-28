package com.data_Structure.linear_list;

/**
 * @Auther: 李爽
 * @Date: 2018/12/23 14:39
 * @Description:
 */
public class DefaultStrategy implements Strategy {
    @Override
    public boolean equal(Object obj1, Object obj2) {
        return false;
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        return 0;
    }
}
