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
    public void deleteFromSToT(int s, int t, ListArray list){
        int k = 0;//记录在s和t之间的数
        for (int i = 0; i < list.getSize(); i++) {
            if ((int)list.get(i)>=s&&(int)list.get(i)<=t){  //当元素在s-t之间时，k加1
                k++;
            }else{
                list.replace(i-k,list.get(i));      //当元素不在s-t之间时，将元素前移动k个位置
            }
        }
        //删除后k个元素
        for (int i = list.getSize()-1; i > k; i++) {
            list.remove(i);
        }
    }
}