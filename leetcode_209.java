package leetcode;
/*
给定一个含有n个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
思路：暴力不行O(n^2)
设置双指针，同时从左边出发，一个指针向前滑动，记录最小>=target的数，如果大于，另一指针则滑动，直至<target
 */
public class leetcode_209 {
    public static void main(String[] args){

    }
}

class minS{
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;//最大值
        int index = 0;
        int sum =0;
        for(int i = 0;i<nums.length;i++){
            sum +=nums[i];
            while(sum>=target){
                result = Math.min(result, i - index + 1);
                sum-=nums[index++];
            }
        }
        if (result >nums.length)
            return 0;
        return result;
    }
}
