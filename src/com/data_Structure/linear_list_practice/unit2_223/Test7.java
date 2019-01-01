package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 16:34
 * @Description: 将两个有序顺序表合并成一个新的有序顺序表，并由函数返回结构顺序表
 */
public class Test7 {
    public static ListArray mergeTwoList(ListArray list1, ListArray list2) {
        int i=0,j=0,k=0;
        ListArray newList = new ListArray();
        while (i<list1.getSize()&&j<list2.getSize()){
            if ((int)list1.get(i)<=(int)list2.get(j)){
                newList.insert(k++,list1.get(i++));
            }else {
                newList.insert(k++,list2.get(j++));
            }
        }
        while (i<list1.getSize()){
            newList.insert(k++,list1.get(i++));
        }
        while (j<list2.getSize()){
            newList.insert(k++,list2.get(j++));
        }
        return newList;
    }

    public static ListArray mergeTwoList2(ListArray list1,ListArray list2){
        int i=0,j=0,k=0;
        ListArray newList = new ListArray();
        for (; i < list1.getSize() && j < list2.getSize(); ) {
            if ((int)list1.get(i)<(int)list2.get(j)){
                newList.insert(k++,list1.get(i++));
            }else {
                newList.insert(k++,list2.get(j++));
            }
        }
        while (i<list1.getSize()){
            newList.insert(k++,list1.get(i++));
        }
        while (j<list2.getSize()){
            newList.insert(k++,list2.get(j++));
        }
        return newList;
    }

    //测试
    public static void main(String[] args) {
        ListArray list1 = new ListArray();
        list1.insert(0, 1);
        list1.insert(1, 3);
        list1.insert(2, 5);
        list1.insert(3, 7);
        list1.insert(4, 9);
        ListArray list2 = new ListArray();
        list2.insert(0, 2);
        list2.insert(1, 4);
        list2.insert(2, 6);
        list2.insert(3, 8);
        list2.insert(4, 10);
        //ListArray listArray = mergeTwoList(list1, list2);
        ListArray listArray = mergeTwoList2(list1, list2);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}
