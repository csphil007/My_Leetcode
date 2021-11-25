package leetcode;

import java.util.*;

/*
给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。

返回 至少 能删除数组中的一半整数的整数集合的最小大小。


 */
public class leetcode_1338 {

}

/**
 * 思路：使用map来确定每一个数对应的数量，使用list保存每一个数对应number，然后将list从大到校排列
 */
class lee_1338{
    public int minSetSize(int[] arr) {
        if(arr.length ==0)
            return 0;
        int count_len = 0;
        int res = Integer.MAX_VALUE;
        int target_size = (arr.length+1)/2;
        HashMap<Integer,Integer> map = new HashMap<>();133
        for(int i = 0; i<arr.length; i++){
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                count_len += 1;
            }
            else{
                int temp = map.get(arr[i]);
                map.replace(arr[i],temp+1);
            }
        }
        int[] save = new int[count_len];
        int sum =0;
        for(int i : map.values())
        {
            save[sum++] = i;
        }
        Arrays.sort(save);
        sum =0;
        for(int i = save.length-1; i>=0; i--){
            sum +=save[i];
            if(sum >= target_size)
                return save.length -i;

        }
        return -1;
    }
}

