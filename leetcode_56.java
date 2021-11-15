
package leetcode;
/*
给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class leetcode_56 {
  public static void main(String[] args){

  }
}
/*
思路：设置四个变量，记录左右上下的边界线，嵌套四重循环进行改良
代码比较容易理解
 */

class leetcode_59{
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1;
        int totol_n = n*n;
        int num =1;
        while(num<=totol_n){
            for(int i  = left;i<=right;i++){
                result[top][i]= num;
                num++;
            }
            top++;
            for(int i = top;i<= bottom;i++){
                result[i][right]= num;
                num++;
            }
            right--;
            for(int i = right;i >= left; i--){
                result[bottom][i] = num;
                num++;
            }
            bottom--;
            for(int i = bottom; i>=top;i--){
                result[i][left]=num;
                num++;
            }
            left++;
        }



        return result;
    }
}
