package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 13:17
 * @Description: 从有序顺序表中删除所有其值重复的元素，使表中所有元素的值均不同
 */
public class Test6 {
    //方法1，算法思想：当当前位元素与下一位元素相同时，删除当前位元素，算法时间复杂度O(n*n)
    public static void deleteRepeatValue(ListArray listArray){
        int k = 0;
        for (int i = 0; i < listArray.getSize()-1; i++) {
            if (listArray.get(i)==listArray.get(i+1)){
                k++;
                listArray.remove(i);
            }
        }
    }

    //方法2，算法思想：查找与当前元素不相同的元素，并像插入新表的方法将元素插入，第一个元素视为新表的第一个不同的元素
    //随后将i个不同的元素后的n-i个元素删除，时间复杂度为O(n)
    public static void deleteSame(ListArray listArray){
        int i = 0,j = 0;
        for (; j < listArray.getSize(); j++) {
            if (listArray.get(i)!=listArray.get(j)){
                listArray.replace(++i,listArray.get(j));
            }
        }
        for (int k=listArray.getSize()-1;k>i;k--){
            listArray.remove(k);
        }
    }

    //测试
    public static void main(String[] args) {
        ListArray listArray = new ListArray();
        listArray.insert(0,1);
        listArray.insert(1,2);
        listArray.insert(2,2);
        listArray.insert(3,3);
        listArray.insert(4,3);
        listArray.insert(5,4);
        listArray.insert(6,4);
        listArray.insert(7,5);
        //deleteRepeatValue(listArray);
        deleteSame(listArray);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}