package leetcode;

/**
 *
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 */
public class leetcode_45 {
}

/**
 * 思路：使用贪心算法，使用step数组记录，
 */
class lee_45{
    public int jump(int[] nums) {
        4
    }
}
class lee_45_2{
    public int jump(int[] nums) {
        if(nums ==null || nums.length == 0)
            return 0;
        int step =0;
        int left =0;
        int right =0;
        for(int i = 0; i < nums.length; i ++){
            int nright = Math.min(right,i + nums[i]);
            if(nright < right)
                continue;
            else {
                for(int j = right+1; j <= nright; j ++){

                }
            }
        }
        return step;
    }
}
