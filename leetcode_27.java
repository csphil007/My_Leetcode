package leetcode;
/*
思路1：首先使用暴力破解法，可惜使用二重循环,s
思路2：以空间换时间，设置指针位置

 */
public class leetcode_27 {
    public static void main(String[] args){

    }

}
//思路一
class removeE1{
    public int removeElement(int[] nums, int val) {
        int num_length = nums.length;
        for(int i = 0;i<num_length;i++){
            if(nums[i] == val){
                for(int j = i+1;j<num_length;j++)
                    nums[j-1] = nums[j];
                i--;
                num_length--;
            }
        }
        return  num_length;
    }
}
//思路2
class removeE2{
    public int removeElement(int[] nums, int val) {
        int index=0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]!=val){
                nums[index++]= nums[i];
            }
        }
        return  index;
    }
}
class removeE3{
    public int removeElement(int[] nums, int val) {

        return  -1;
    }
}