package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2019/1/1 10:54
 * @Description: 线性表(a1,a2,a3,...,an)中元素递增有序且按顺序存储于计算机内。要求设计一算法完成用最少时间在表中查找数值为x的元素，若找到将其后继元素位置交换，若找不到将其插入表中并使表中元素仍递增有序。
 */
public class Test9 {

    //要求在最少时间内完成，故使用折半查找
    public static void search(ListArray listArray,Object x){
        int size = listArray.getSize();
        int low = 0,high = size-1,mid=0;
        while (low<=high){      //二分查找，如果找到跳出循环
            mid = (low+high)/2;
            if (listArray.get(mid)==x)break;
            else if ((int)listArray.get(mid)<(int)x) low=mid+1; //若中间值小于x的值，则到下半区查找
            else high=mid-1;
        }
        if (listArray.get(mid)==x&&mid!=size-1){    //如果查找到该值，则将该值和下一值反转，如果查找到的是最后一值，则不进行操作
            Object temp = listArray.get(mid);
            listArray.replace(mid,listArray.get(mid+1));
            listArray.replace(mid+1,temp);
        }
        if (low>high){      //如果不存在该值，则插入该值到相应位置
            int i = high;
            listArray.insert(i+1,x);
        }
    }

    //测试
    public static void main(String[] args) {
        ListArray listArray = new ListArray();
        listArray.insert(0,1);
        listArray.insert(1,2);
        listArray.insert(2,3);
        listArray.insert(3,3);
        listArray.insert(4,5);
//        search(listArray,5);
//        search(listArray,4);
        search(listArray,6);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}