package leetcode;

import java.util.Arrays;

/*/
author:phil
data:11-1;
思路：设置索引指针，遇到零向前覆盖
 */
public class leetcode_283 {
    public static void main(String[] args){
        int[] nums = {0,1,1,1,0,3,34};
        Move_zero m = new Move_zero();
        m.moveZeroes(nums);
        //for(int i:nums)
        //    System.out.println(nums[i]);
        System.out.println(Arrays.toString(nums));
    }
}

//此方法使用向前覆盖的思路
class Move_zero{
    public void moveZeroes(int[] nums) {
        int nums_length = nums.length;
        int index=0;
        for(int i = 0; i<nums_length; i ++){
            if(nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        for(int i= index; i<nums_length;i++){
            nums[i]=0;
        }
    }
}



