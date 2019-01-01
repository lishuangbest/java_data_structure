package com.data_Structure.linear_list_practice.unit2_223;

import com.data_Structure.linear_list.ListArray;

/**
 * @Auther: 李爽
 * @Date: 2018/12/31 10:36
 * @Description: 从顺序表中删除具有最小值的元素(假设唯一)并由函数返回被删元素的值，空出的位置由最后
 *               一个元素填补，若顺序表为空则显示出错信息并退出运行。
 */
public class Test1 {
    //假设存储的是整型数
    public static Object deleteMinValue(ListArray listArray){
        if (listArray.getSize()==0){ //顺序表大小为0，抛出异常
            throw new NullValueListException("错误：顺序表为空。");
        }
        int min = 0;    //定义用以获取最小值的索引
        int value = (int)listArray.get(0);  //定义用以存储最小值的中间变量
        for (int i = 0; i < listArray.getSize(); i++) { //遍历获取最小值及索引
            if ((int)listArray.get(i)<value){
                value =(int) listArray.get(i);
                min = i;
            }
        }
        listArray.replace(min,listArray.get(listArray.getSize()-1));    //将最后一位元素替换被删除的最小值
        listArray.remove(listArray.getSize()-1);    //删除最后的一位元素
        return value;
    }

    //测试
    public static void main(String[] args) {
        ListArray listArray = new ListArray();
        listArray.insert(0,1);
        listArray.insert(1,2);
        listArray.insert(2,3);
        listArray.insert(3,4);
        listArray.insert(4,5);
        deleteMinValue(listArray);
        for (int i = 0; i < listArray.getSize(); i++) {
            System.out.println(listArray.get(i));
        }
    }
}
