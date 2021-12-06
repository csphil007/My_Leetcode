package leetcode;

import java.util.*;

public class leetcode_260 {
}
/*
使用hashmap
 */

class lee_260{
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        int[] res =new int[2];
        int index= 0;
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
            if(entry.getValue() == 1)
                res[index++] = entry.getKey();
        }
        return res;
    }
}
