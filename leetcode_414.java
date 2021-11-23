package leetcode;

import java.util.Arrays;

public class leetcode_414 {
    public static void main(String[] args){
        int a[]={3,2,1};
        lee_4142 s = new lee_4142();
        int re = s.thirdMax(a);
    }
}
/*
先进性排序，时间复杂度稍微较高哦
 */
class lee_414{
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int i =0;
        int t_m= 1;
        if(nums.length<3)
            return nums[nums.length-1];
        for(i = nums.length-1; i>0;i--){
            if(t_m ==3){
               break;}
            if(nums[i] == nums[i-1])
                t_m --;
            t_m++;
        }
        if(t_m<3)
            return nums[nums.length-1];
        return nums[i];
    }
}
/*
写一个不用排序的方法
同时可以用第三种方法，hashset的属性唯一
 */
class lee_4142{
    public int thirdMax(int[] nums) {
        if(nums.length ==1)
            return nums[0];
        if(nums.length ==2)
            return Math.max(nums[0],nums[1]);
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[1];
            }
            else if(nums[i]>max2 && nums[i] < max1){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] > max3 && nums[i] < max2){
                max3 = nums[i];
            }
        }
        return max1;
    }
}