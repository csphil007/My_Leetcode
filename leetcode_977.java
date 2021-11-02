package leetcode;
/*
要求时间复杂度为O(n)
思路：平方再排序时间复杂度为至少要o(nlogn)
由于数组本省是有序的，可以使用双指针法，左右各一个指针，最大的数往往出现在两端，比较两端平方以后的值，讲大的数值放在
重新定义的数组的末端
 */


public class leetcode_977 {
    public static void main(String[] args){
        youxuPngf y = new youxuPngf();
        int[] nums = {-4,-1,0,3,10};
        y.sortedSquares(nums);

    }
}

class youxuPngf{
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1;
        int[] result =new int[nums.length];
        int index = right;
        while (left <= right){
            if(nums[left] * nums[left] <= nums[right] * nums[right]){
                result[index--] = nums[right] * nums[right];
                right--;
            }
            else{
                result[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}
