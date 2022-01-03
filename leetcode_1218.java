package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列

 */
public class leetcode_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        //首先使用自己的方法试一下//结果超时
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int target = arr[i];
            int num = 0;
            for(int  j = i+1; j<arr.length;j++){
                if(target + difference == arr[j]){
                    num++;
                    target+=difference;
                }
            }
            if(num> res)
                res = num;
        }
        return res;
    }


    /**
     * 使用动态规划
     * 我们从左往右遍历 arr，并计算出以 arr[i] 为结尾的最长的等差子序列的长度，取所有长度的最大值，即为答案。
     *dp[i] 表示以 arr[i] 为结尾的最长的等差子序列的长度，我们可以在 arr[i] 左侧找到满足
     * arr[j]=arr[i]−d 的元素，将 ]arr[i] 加到以 ]arr[j] 为结尾的最长的等差子序列的末尾，这样可以递推地从 dp[j] 计算出 dp[i]。由于我们是从左往右遍历arr 的，
     * 对于两个相同的元素，下标较大的元素对应的 dp 值不会小于下标较小的元素对应的dp 值，因此下标 j可以取满足 j<i 且arr[j]=arr[i]−d 的所有下标的最大值。故有转移方
     * dp[i]=dp[j]+1

     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence_2(int[] arr, int difference) {
        int res =0;
        Map<Integer, Integer> dp = new HashMap<>();
        for(int i : arr){
            dp.put(i,dp.getOrDefault(i -difference,0)+1);
            res = Math.max(res, dp.get(i));
        }
        return res;

    }

}
