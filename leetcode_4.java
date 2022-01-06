package leetcode;

public class leetcode_4 {
    public static void main(String[] args) {
        lee4 l = new lee4();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        l.findMedianSortedArrays(nums1,nums2);
    }
}

class lee4{
    /**
     * 寻找两个正序数组的中位数

     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] cot = new int[len1+len2];
        if(len1 == 0 && len2 ==1){
            return Double.valueOf(nums2[0]);
        }
        if(len1 == 1 && len2 == 0) {
            return Double.valueOf(nums1[0]);
        }
        int index =0;
        int i= 0, j=0;
        while(i<len1 && j<len2){
            if(nums1[i]<=nums2[j]){
                cot[index++] = nums1[i];
                i++;
            }else {
                cot[index ++] = nums2[j];
                j++;
            }
        }
        if(i == len1){
            for(j =j; j<len2;j++){
                cot[index++] = nums2[j];
            }
        }else {
            for(i = i;i<len1; i++){
                cot[index++] = nums1[i];
            }
        }
        if((len1 + len2)%2 !=0){
            return Double.valueOf(cot[(len1+len2)/2]);
        }
        double one  = cot[(len1+len2)/2];
        double two = cot[(len1+len2)/2-1];
        return Double.valueOf((one+two)/2);
    }
}