package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 12:43
 * @Description: 从顺序表中删除其值在给定值s与t之间(包含s和t，且s<t)的所有元素，如果s或t不合理或者顺序表为
 *               空则显示出错信息并退出运行。
 */
public class Test5 {
    //假定存储的均为整型数
    public static void deleteFromSToT(int s, int t, ListArray list){
        int k = 0;//记录在s和t之间的数
        for (int i = 0; i < list.getSize(); i++) {
            if ((int)list.get(i)>=s&&(int)list.get(i)<=t){  //当元素在s-t之间时，k加1
                k++;
            }else{
                list.replace(i-k,list.get(i));      //当元素不在s-t之间时，将元素前移动k个位置
            }
        }
        //删除后k个元素
        int size = list.getSize();
        for (int i = size - 1; i > size-1-k; i--) {
            list.remove(i);
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
        listArray.insert(5,3);
        listArray.insert(6,2);
        listArray.insert(7,4);
        deleteFromSToT(2,4,listArray);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}