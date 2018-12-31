package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 10:48
 * @Description: 设计一个高效的算法，将顺序表的所有元素逆置，要求算法的空间复杂度为O(1)。
 */
public class Test2 {
    public static void reversalListArray(ListArray listArray){
        Object obj; //定义中间变量，用以暂存先被替换的元素
        for (int i = 0; i < listArray.getSize()/2; i++) {
            obj = listArray.get(i);
            listArray.replace(i,listArray.get(listArray.getSize()-i-1));
            listArray.replace(listArray.getSize()-i-1,obj);
        }
    }
}