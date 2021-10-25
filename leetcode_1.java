class Solution {
    public int[] twoSum(int[] nums, int target) {
        int volume =2048; //100000000000
        int bitMode = volume-1;//011111111111
        int [] result =new int[volume];
        for (int i=0;i<nums.length;i++){
            int c = (target - nums[i]) & bitMode;
            if (result[c]!=0){
                return new int[]{result[c]-1,i};
            }
            result[nums[i] & bitMode]=i+1;
        }
        return null;
    }
}

