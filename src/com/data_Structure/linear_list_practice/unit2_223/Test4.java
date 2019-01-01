package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 12:21
 * @Description: 从有序顺序表中删除其值在给定值在给定值s与t之间(要求s<t)的所有元素，如果s或t不合理或者顺序表为
 *               空则显示出错信息并退出运行。
 */
public class Test4 {
    //假定顺序表中存储的均为整型常量
    /*
    算法思想：由于顺序表是有序的且s和t之间的元素是连续的，要实现st之间元素的删除，使用t后的元素从s后开始替换即可
    先寻找大于s的第一个元素，再找到大于t的第一个元素，替换即可
     */
    public static void deleteFromSToT(int s, int t, ListArray list){
        if (s>t){
            throw new NullValueListException("错误：s值大于t值。");
        }
        if (list.isEmpty())
            throw new NullValueListException("错误：顺序表为空。");
        int i,j;
        for (i = 0; i < list.getSize()&&(int)list.get(i) < s; i++);//查找第一个大于s的元素的索引
        if (i>list.getSize())
            throw new NullValueListException("错误：i超出集合长度"); //不定义新的异常类，偷个懒
        for (j = 0; j < list.getSize()&&(int)list.get(j) <= t; j++);//查找第一个大于t的元素的索引
        for (; j<list.getSize() ; i++,j++) {
            list.replace(i,list.get(j));        //使用t后的元素替换s-t之间的元素
        }
        for (int k = list.getSize()-1; k >= i; k--) {
            list.remove(k);     //删除替换完成后的i后面的元素
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
        deleteFromSToT(2,4,listArray);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}
