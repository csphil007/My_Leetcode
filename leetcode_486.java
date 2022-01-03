package leetcode;

public class leetcode_486 {
}
/*
leetcode 486  预测赢家
 */
class lee_486{
    /**
     * 方法1： 递归
     * 为了判断哪个玩家可以获胜，需要计算一个总分，即先手得分与后手得分之差。当数组中的所有数字都被拿取时，如果总分大于或等于 00，则先手获胜，反之则后手获胜。
     *
     * 由于每次只能从数组的任意一端拿取数字，因此可以保证数组中剩下的部分一定是连续的。假设数组当前剩下的部分为下标 \textit{start}start 到下标 \textit{end}end，其中 0 \le \textit{start} \le \textit{end} < \textit{nums}.\text{length}0≤start≤end<nums.length。如果 \textit{start}=\textit{end}start=end，则只剩一个数字，当前玩家只能拿取这个数字。如果 \textit{start}<\textit{end}start<end，则当前玩家可以选择 \textit{nums}[\textit{start}]nums[start] 或 \textit{nums}[\textit{end}]nums[end]，然后轮到另一个玩家在数组剩下的部分选取数字。这是一个递归的过程。
     *
     * 计算总分时，需要记录当前玩家是先手还是后手，判断当前玩家的得分应该记为正还是负。当数组中剩下的数字多于 11 个时，当前玩家会选择最优的方案，使得自己的分数最大化，因此对两种方案分别计算当前玩家可以得到的分数，其中的最大值为当前玩家最多可以得到的分数。
     * @param nums 输入的数组
     * @return true/false 判断是否可以赢
     */
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1 , 1 ) > 0;
    }
    private int total(int[] nums, int start, int end, int turn){
        if(start == end)
            return nums[start] * turn;
        int ScoreStart = nums[start]*turn + total(nums, start+1, end, -turn);
        int Scoreend = nums[end]*turn +  total(nums, start, end -1 , -turn);
        return Math.max(ScoreStart * turn, Scoreend *end)*turn;
    }
}

class lee_486_2{
    /**
     * 使用动态规划
     * 思路：建立一个dp[len][len]数组，dp[i][j]表示nums i, j 下表玩家1 获得分数减去玩家2的最大分数差，最后看dp[0][len-1]的数值是否大于0
     * 先看dp[i][j]存储玩家1能从任意子数组[i,j]中获得的最大分数的情况：
     * 给定一个数组nums[i,j]，玩家1能够拿nums[i]或者nums[j]， 剩下一个新的数组nums[i+1, j]或者nums[i, j-1]，然后轮到玩家2拿，因为是博弈游戏，所以玩家2能拿到的最大数值是玩家1能拿到的最大数值。
     * dp(i, j) = max((sum(i, j-1) - dp(i, j-1) + nums[j]), (sum(i+1, j) - dp(i+1, j) + nums[i])) =
     * max((sum(i, j) - dp(i, j-1)), (sum(i, j) - dp(i-1, j))) = sum(i, j) - min(dp(i-1, j), dp(i, j-1))
     *dp[i][j]=max(nums[i]−dp[i+1][j],nums[j]−dp[i][j−1])
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int len =  nums.length;
        int[][] dp =new  int[len][len];
        for(int i =0 ;i<len; i ++){
            dp[i][i] = nums[i];
        }
        for(int  i = len -2; i >=0; i--){
            for(int j = i +1; j <len; j++){
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][len-1]>0;
    }

}