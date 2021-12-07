package leetcode;

/**
 *实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 */
public class leetcode_31 {
}

/**
 * 思路：从后往前找一个非降序的数，然后从后往前找一个比上一个稍微大的数，
 * 注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
 *
 * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
 *
 * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
 *
 * 以排列 [4,5,2,6,3,1][4,5,2,6,3,1] 为例：
 *
 * 我们能找到的符合条件的一对「较小数」与「较大数」的组合为 22 与 33，满足「较小数」尽量靠右，而「较大数」尽可能小。
 *
 * 当我们完成交换后排列变为 [4,5,3,6,2,1][4,5,3,6,2,1]，此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6][4,5,3,1,2,6]。
 */
class lee_31{
    public void nextPermutation(int[] nums) {
        int i  =nums.length-2;//这里为什么是-2因为要与前面一个进行比u叫
        while(i>=0 && nums[i] >= nums[i+1])
            i --;
        if(i>=0)
        {
            int j = nums.length - 1;
            while(j >= 0  && nums[i]>=nums[j])
                j--;
            swap(nums,i,j);
        }
        reverse(nums, i + 1);


    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
