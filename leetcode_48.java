package leetcode;
/*
给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class leetcode_48 {
}
/*
思路：使用两次翻转
 */
class lee_48{
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len == 0 || matrix[0].length !=len){
            return;
        }
        for(int i = 0; i < len; i ++){
            for(int j = 0; j < i; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //第二次翻转，沿着垂直角度进行
        for(int i =0; i< len;i++){
            for(int j = 0, k =len-1; j < k; j++, k--){
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
