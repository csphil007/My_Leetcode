package leetcode;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。
思路1：由于是顺序数组，那首先可以采用顺序遍历的方法，时间复杂度为O(n)，时间复杂度有点大了
思路2：二分法，获取middle值，再由middle往左右扩展，查找组左边和最右边，当前解题思路用的是此种方法
思路3：同样是二分法，编写两个方法同时获取左边边界和右边边界
 */
public class leetcode_34 {
    public static void main(String[] args){
        find_firandlast f = new find_firandlast();
        int[] nums = {2,2};
        int target  = 2;
        int[] re =new int[2];
        re = f.searchRange(nums,target);
        System.out.println(re[0]);
        System.out.println(re[1]);
    }
}

class find_firandlast{
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int left = 0;
        int right = nums.length-1;
        if (nums.length == 0)
            return result;
        int middle = (left+right)/2;
        while(left<=right){
            middle = (left+right)/2;
            if(nums[middle] == target)
                break;
            else if(nums[middle] < target)
                left = middle+1;
            else if (nums[middle]> target)
                right = middle-1;
        }
        if(nums[middle]!= target)
            return result;
        else{
            int temp = middle-1;
            result[0] = middle;
            result[1] = middle;
            while(temp>=0){
                if(nums[temp] !=target)
                    break;
                result[0] = temp;
                temp -= 1;
            }
            temp = middle+1;
            while(temp<nums.length){
                if(nums[temp] !=target)
                    break;
                result[1] = temp;
                temp += 1;
            }

        }
        return result;
    }

}
