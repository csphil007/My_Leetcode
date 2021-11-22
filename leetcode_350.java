package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_350 {
    public static void main(String[] args){

    }
}
/*
思路；求交集，首先对两数组进行排序，然后再俩俩比较选取
 */
class lee_350{
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result =new int[res.size()];
        for(int i = 0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
