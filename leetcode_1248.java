package leetcode;
/*
给你一个整数数组nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。
。
 */
public class leetcode_1248 {
}

class lee_1248{
    /**
     * 统计「优美子数组」
     * 不断右移 right 指针来扩大滑动窗口，使其包含 k 个奇数；
     *
     * 若当前滑动窗口包含了 k 个奇数，则如下「计算当前窗口的优美子数组个数」：
     *
     * 统计第 1 个奇数左边的偶数个数 leftEvenCnt。 这 leftEvenCnt 个偶数都可以作为「优美子数组」的起点，因此起点的选择有 leftEvenCnt + 1 种（因为可以一个偶数都不取，因此别忘了 +1 喔）。
     * 统计第 k 个奇数右边的偶数个数 rightEvenCnt。 这 rightEvenCnt 个偶数都可以作为「优美子数组」的终点，因此终点的选择有 rightEvenCnt + 1 种（因为可以一个偶数都不取，因此别忘了 +1 喔）。
     * 因此「优美子数组」左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)。
     *
     * 思路：重点在连续，可以使用双指针
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, oddCnt = 0, res = 0;
        while (right < nums.length) {
            // 右指针先走，每遇到一个奇数则 oddCnt++。
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }

            //  若当前滑动窗口 [left, right) 中有 k 个奇数了，进入此分支统计当前滑动窗口中的优美子数组个数。
            if (oddCnt == k) {
                // 先将滑动窗口的右边界向右拓展，直到遇到下一个奇数（或出界）
                // rightEvenCnt 即为第 k 个奇数右边的偶数的个数
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                // leftEvenCnt 即为第 1 个奇数左边的偶数的个数
                int leftEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }
                // 第 1 个奇数左边的 leftEvenCnt 个偶数都可以作为优美子数组的起点
                // (因为第1个奇数左边可以1个偶数都不取，所以起点的选择有 leftEvenCnt + 1 种）
                // 第 k 个奇数右边的 rightEvenCnt 个偶数都可以作为优美子数组的终点
                // (因为第k个奇数右边可以1个偶数都不取，所以终点的选择有 rightEvenCnt + 1 种）
                // 所以该滑动窗口中，优美子数组左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)
                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);

                // 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                oddCnt--;
            }

        }

        return res;
    }
}


