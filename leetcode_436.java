package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个区间数组 intervals ，其中intervals[i] = [starti, endi] ，且每个starti 都 不同 。
 *
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj>= endi ，且 startj 最小化 。
 *
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 *
**/
public class leetcode_436 {
}
/*
首先使用暴力法
 */
class lee_436{
    public int[] findRightInterval(int[][] intervals) {
        int []res = new int[intervals.length];
        for(int i = 0; i<intervals.length; i++){
            int min = Integer.MAX_VALUE;
            int minindex= -1;
            for(int j = 0;j<intervals.length;j ++){
                if(intervals[j][0] >= intervals[i][1] && intervals[j][0] < min){
                    min =  intervals[j][0];
                    minindex = j;
                }
            }
            res[i] = minindex;
        }
        return res;
    }
}
/**
 *
 * 暴力法的时间复杂度高，
 * 我们使用一个哈希表hash，存储的数据形式的键值对。在这里，Key 对应区间，而 \text{Value}Value 对应在 intervals 数组中特定区间的索引。我们将intervals 中的每个元素存储在哈希表中。
 *
 * 我们根据区间的起点对 \text{intervals}intervals 数组进行排序。我们需要将数组的索引存储在哈希表中，以便排序后也能获得对应的索引。
 *
 * 然后，依次遍历数组中的区间，并找到在该区间结束位置后的一个区间。怎么找？由于intervals 数组是基于起点排序的，并且对于给定的区间，结束点总是大于起始点。因此我们只需要使用索引 j 搜索区间，i+1<j<n，这样按升序扫描时遇到第一个区间就是所需的结果。
 *
 * 然后，我们可以在哈希表中获取该区间对应的索引，将该索引存储到 res 数组中。
 *
 */

class lee_436_2{
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        Map<int[], Integer> hash = new HashMap<>();
        for(int i =0; i < intervals.length;i++){
            hash.put(intervals[i],i);
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int i =0;i<intervals.length;i++){
            int min = Integer.MAX_VALUE;
            int minindex = -1;
            for(int j = i+1;j<intervals.length;j++){
                if(intervals[j][0] >= intervals[i][1] && intervals[j][0] < min){
                    min =  intervals[j][0];
                    minindex = hash.get(intervals[j]);
                }
            }
            res[hash.get(intervals[i])] = minindex;
        }
        return res;
    }
}
/**
 * hashTree
 */
class Lee_3 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] leftAndIndex = new int[n][2]; //存每个数对（区间的起点值，该区间的下标）
        for (int i = 0; i < n; i++) {
            leftAndIndex[i] = new int[]{intervals[i][0], i};
        }
        Arrays.sort(leftAndIndex, (a, b) -> a[0] - b[0]); //根据区间的起点值进行排序
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1]; //设目标值为结尾值
            int l = 0, r = n - 1;
            int index = -1;
            //在leftAndIndex中找大于等于target的第一个坐标
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (leftAndIndex[mid][0] < target) l = mid + 1;
                else if (leftAndIndex[mid][0] > target) r = mid - 1;
                else {
                    index = leftAndIndex[mid][1];
                    break;
                }
            }
            if (index == -1 && l < n) index = leftAndIndex[l][1]; //如果没有找到等于target的，那就设为比target大的第一个坐标
            ans[i] = index;
        }
        return ans;
    }
}
