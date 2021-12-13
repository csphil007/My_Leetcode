package leetcode;

/**
 *峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class leetcode_162 {
}
/*
pan
 */
class lee_162{
    public int findPeakElement(int[] nums) {
        if(nums.length==2){
            if(nums[0]>nums[1])
                return 0;
            else
                return 1;
        }
        int index= 0;
        for(int i = 1 ;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&& nums[i]>nums[i+1]) {
                index = i;
                return index;
            }
        }
        if(index == 0)
        {
            if(nums[0]>nums[nums.length-1])
                return 0;
            else {
                return nums.length-1;
            }
        }
        return 0;
    }
}

class lee_162_2 {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
