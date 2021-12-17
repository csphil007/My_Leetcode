package leetcode;

import java.util.*;

/*
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

        （这里，平面上两点之间的距离是欧几里德距离。）

        你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
*/
public class leetcode_973 {
}
class lee_973 {
    /**
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return (p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]);
            }
        });
        //Arrays.sort(points, Comparator.comparingInt((array) -> array[0] * array[0] + array[1] * array[1]));//至尊吊

        return Arrays.copyOfRange(points,0,k);
    }
}
class lee_973_2 {
    /**
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        Map<Long, int[]> map =new TreeMap<>();
        for(int[] p : points){
            long res= p[0]*p[0]+p[1]*p[1];
            map.put(res,p);
        }
        int i =0;
        int[][] res = new int[k][2];
        for(long len: map.keySet()){
            if(i ==k)
                break;
            int[] s = map.get(len);
            res[i++] = s;
        }
        return res;
    }
}