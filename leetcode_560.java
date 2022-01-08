package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;

/*和为k得子数组
给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 */
public class leetcode_560 {
    public static void main(String[] args) {
        lee560 l =new lee560();
        int[] nums = {-1,-1,1};
        int k = 0;
        l.subarraySum(nums,k);
    }
}
class lee560{
    /**
     * 思路：使用双指针,但是不太行，因为数组不一定全是
     * @param nums 数组
     * @param k 目标和
     * @return numbers of
     */
    public int subarraySum(int[] nums, int k) {
        int left =0, right = 0;
        int cot = 0;
        int res = 0;
        int len = nums.length;
        if(len ==1 && nums[0]!=k)
            return 0;
        for(right=0;right<len;right++){
            cot += nums[right];
            if(cot == k){
                res+=1;
                cot-=nums[left];
                left++;
            }
            else if (cot >k){
                while(left<=right && cot > k){
                    cot-= nums[left];
                    left++;
                }
                if(cot == k)
                    res++;
            }else {
                continue;
            }

        }
        return res;
    }

    /**
     * 使用双重for循环，从后往前找
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int res =0;
        for(int i =0; i<nums.length ;i++){
            int sum = 0;
            for(int j = i; j>=0;j--){
                sum+=nums[j];
                if(sum == k)
                    res+=1;
            }
        }
        return res;
    }
    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}