package leetcode;
/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
思路：设置指针有序覆盖，如果前一个和后一个重复，就进行覆盖


 */
public class leetcode_26 {
    public static void main(String[] args){

    }
}

class Move {
    public int removeDuplicates(int[] nums) {
        int index= 1;
        for( int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
