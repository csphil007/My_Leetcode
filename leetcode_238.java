package leetcode;
/*
除自身以外数组的乘积
给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 */
public class leetcode_238 {
}

class lee238{
    /**
     * 定义三个数组，左侧，右侧，res
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] res = new int[len];
        L[0] = 1;
        R[len-1]  = 1;
        for(int i = 1; i<len;i++){
            L[i] = L[i-1]*nums[i-1];
        }
        for(int i = len-2; i>=0;i--){
            R[i] = R[i+1]* nums[i+1];
        }
        for(int i = 0; i<len;i++){
            res[i]= L[i]* R[i];
        }
        return res;
    }
}