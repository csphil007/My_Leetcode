package leetcode;

import java.util.*;

/*
题意：给定两个数组，编写一个函数来计算它们的交集。
 */
public class leetcode_349 {
    public static void main(String[] args){


    }
}
/*
思路：求交集
 */
class lee_349{
    public int[] intersection(int[] nums1, int[] nums2) {
        int len_num1 = nums1.length, len_num2 = nums2.length;
        int temp =0, min;
        if(len_num1>=len_num2)
            min = len_num2;
        else{
            temp =1;//nums1小
            min = len_num1;
        }
        //int min =(len_num1 > len_num2)? len_num2: len_num1;
        int[] res = new int[min];
        int res_index =0;
        if(temp == 0){//nums2小
            for(int i = 0; i<min; i++){
                if(Arrays.asList(nums1).contains(nums2[i])==true){
                    res[res_index] = nums2[i];
                    res_index++;
                }
            }
        }
        else{
            for(int i = 0; i<min; i++){
                if(Arrays.asList(nums2).contains(nums1[i])==true){
                    res[res_index] = nums1[i];
                    res_index++;
                }
            }
        }
        List<Integer> final_res = new ArrayList<>();
        Arrays.sort(res);
        int index =1;

        return null;
    }
}
/*
使用hashset, 是一种元素不可重复的list
 */
class lee_349_2{
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res1 = new HashSet<>();
        HashSet<Integer> fin_res = new HashSet<>();
        for(int i: nums1)
            res1.add(i);
        for(int  i: nums2){
            if(res1.contains(i) == true)
                fin_res.add(i);
        }
        int[] result =new int[fin_res.size()];
        int index =0;
        for(int i:fin_res){
            result[index++]=i;
        }
        return result;
    }
}
