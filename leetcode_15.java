package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 */
public class leetcode_15 {
}
/*
双指针法思路： 固定 3 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，通过双指针交替向中间移动，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 33 个数字都大于 00 ，在此固定指针 k 之后不可能再找到结果了。
当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动：
当s < 0时，i += 1并跳过所有重复的nums[i]；
当s > 0时，j -= 1并跳过所有重复的nums[j]；
当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
 */
class lee_15{
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3)
            return Collections.emptyList();
        //List<Integer> con = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0)
                break;
            if(i > 0 && nums[i] == nums[i-1]) //去重，去i的重复
                continue;
            int concret = nums[i];
            int j = i+1,k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0)
                    j++;
                else if(sum >0)
                    k--;
                else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j],nums[k])));
                    while(j<k && nums[j] == nums[++j]);//去jk的重复
                    while(j< k && nums[k] == nums[--k]);
                }

            }

        }
        return res;
    }
}
