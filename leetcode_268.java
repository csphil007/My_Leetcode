package leetcode;

import java.util.HashMap;

/**
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 */
public class leetcode_268 {
}
class lee_268{
    public int missingNumber(int[] nums) {
        int[] temp =new int[nums.length+1];
        for(int i =0;i<nums.length;i++){
            temp[nums[i]]=1;
        }
        for(int i =0;i<nums.length;i++){
            if(temp[i]==0)
                return i;
        }
        return nums.length;
    }
}
class lee_268_2{
    public int missingNumber(int[] nums) {
        kuaipai(nums,0,nums.length-1);
        for(int i =0;i<nums.length;i++)
            if(nums[i]!=i)
                return i;
        return nums.length;
    }
    private void kuaipai(int[] nums,int low,int high){
        if(low>high)
            return;
        int i ,j ,temp ,t;
        i =low;
        j = high;
        temp = nums[i];
        while(i<j){
            //先看右边
            while (temp<nums[j] && i<j)
                j--;
            //再看左边
            while(temp>= nums[i]&& i<j)
                i++;
            if(i<j){
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        kuaipai(nums, low, j-1);
        kuaipai(nums, j+1, high);
    }

}