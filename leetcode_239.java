package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode_239 {
    public static void main(String[] args){
        lee_239_2 l = new lee_239_2();
        int nums[] ={-7,-8,7,5,7,1,6,0};
        int re[] = l.maxSlidingWindow(nums,3);
    }

}

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */
/*
首先这种方法可以，但是容易超出时间限制
 */
class lee_239{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length < k) return nums;
        int[] res = new int[length-k+1];
        for(int i =0; i<length-k+1;i++)
        {
            res[i]= sele_max(nums, i,i+k-1);
        }
        return res;

    }
    private int sele_max(int[] nums,int i,int j){
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k ++){
            if(nums[k]>max)
                max= nums[k];
        }
        return max;
    }

}

/*
思路：判断nums[i-1]与结果res[i-1]与nums[i+k-1]三者的关系；
 */
class lee_239_2{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length < k) return nums;
        int[] res = new int[length-k+1];
        res[0] = sele_max(nums,0,k-1);
        for(int i =1; i<length-k+1;i++)
        {
            if(res[i-1]<= nums[i+k-1])
                res[i] = nums[i+k-1];
            else {
                if(nums[i-1] <= nums[i+k-1])
                    res[i] = res[i-1];
                else {
                    if(nums[i-1] == res[i-1])
                        res[i] = sele_max(nums, i, i+k-1);
                    else{
                        res[i] = res[i-1];
                    }
                }
            }

        }
        return res;
    }
    private int sele_max(int[] nums,int i,int j){
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k ++){
            if(nums[k]>max)
                max= nums[k];
        }
        return max;
    }

}


/**
 * 第二种方法对于第一种方法做了改进，但是仍然不行，时间效果太差,于是有了方法三：
 *可以采用双端队列的方式，来看采用双端队列的原因
 * 每一个数入队列，都与队列内的位于队尾的数比较，如果大于队尾的数，则删掉队尾，直到队列为空或者不大于队尾元素，将此数插入队尾。
 */
class lee_239_3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //先声明return数组
        int[] ret = new int[nums.length-k+1];
        //这里用到了LinkedList，前面的接口Deque就是双端队列，这个不是关键
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //这里就是主要逻辑，当前元素是否大于队尾元素，如果大于就删除
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }
            //如果不大于，或者队列为空了，则加入下标
            deque.addLast(i);
            //这里就是判断，两个下标差是否等于k，如果等于就删除头部
            if (i-deque.getFirst() == k){
                deque.removeFirst();
            }
            //这里说明什么时候将队列头加入return数组
            if (i-k+1 >=0){
                ret[i-k+1] = nums[deque.getFirst()];
            }
        }
        return ret;
    }
}
