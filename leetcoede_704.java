package leetcode;
/*给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。

思路一：顺序查找，时间复杂度为n
思路2：二分查找


 */
public class leetcoede_704 {
    public static void main(String[] args){

    }

}

class Soultion{
    public static int findnumbers(int[] nums,int target){
        int left = 0;
        int right =  nums.length-1;
        while( left<= right){
            int middle = (left + right) / 2;//这里面可能会产生内存溢出，
            if(target == nums[middle]){
                return middle;
            }
            else if(target < nums[middle]){
                right = middle - 1;
            }
            else if(target > nums[middle]){
                left = middle + 1;
            }

        }
        return -1;
    }


}
