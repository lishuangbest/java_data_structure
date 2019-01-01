package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 10:57
 * @Description: 长度为n的顺序表L，编写一个时间复杂度为O(n)、空间复杂度为O(1)的算法，该算法删除线性表中所有值
 *               为x的数据元素
 */
public class Test3 {

    //记录值不等于x的个数k，边循环边统计，将不等于x的元素放到k位置上，最后修改L的长度，本题由于ListArray私有化了size属性
    //故需循环删除k后面的元素，略不符合题意
    public static void deleteValueX(ListArray L,Object x){
        int k = 0;  //记录不等于x的元素的个数
        for (int i = 0; i < L.getSize(); i++) {
            if (!L.get(i).equals(x)){
                L.replace(k,L.get(i));
                k++;
            }
        }
        if (k<L.getSize()){
            for (int i = L.getSize()-1; i >= k; i--) {
                L.remove(i);
            }
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
        deleteValueX(listArray,3);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}
