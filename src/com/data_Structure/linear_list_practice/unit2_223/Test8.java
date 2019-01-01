package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 18:45
 * @Description: 已知在一维数组A[m+n]中依次存放着两个线性(a1,a2,...,am)和(b1,b2,...,bn)。试编写
 *               一个函数，将数组中两个顺序表的位置互换，即将(b1,b2,...,bn)放在(a1,a2,...,am)前面
 */
public class Test8 {

    //逆转
    public static ListArray reverse(ListArray listArray,int left,int right,int arraySize){
        if (left>=right||right>=arraySize){
            return null;
        }
        Object temp;
        int size = left + right;
        for (int i = 0; i <= (size/2)-left; i++) {
            temp = listArray.get(left+i);
            listArray.replace(left+i,listArray.get(right-i));
            listArray.replace(right - i,temp);
        }
        return listArray;
    }

    //交换
    public static void exchange(ListArray list,int m,int n,int arraySize){
        reverse(list,0,m+n-1,arraySize);
        reverse(list,0,n-1,arraySize);
        reverse(list,n,m+n-1,arraySize);
    }

    //测试
    public static void main(String[] args) {
        ListArray listArray = new ListArray();
        listArray.insert(0,1);
        listArray.insert(1,2);
        listArray.insert(2,3);
        listArray.insert(3,4);
        listArray.insert(4,5);
        listArray.insert(5,5);
        listArray.insert(6,4);
        listArray.insert(7,3);
        listArray.insert(8,2);
        listArray.insert(9,1);
        exchange(listArray,5,5,10);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}