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

    //测试
    public static void main(String[] args) {
        ListArray listArray = new ListArray();
        listArray.insert(0,1);
        listArray.insert(1,2);
        listArray.insert(2,3);
        listArray.insert(3,4);
        listArray.insert(4,5);
        reversalListArray(listArray);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}