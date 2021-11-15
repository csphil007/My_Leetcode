package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_54 {
    public static void main(String[] args){
        ArrayList<Integer> List = new ArrayList<Integer>();
        int matrix[][] = {{ 1, 2, 3 }, { 4, 5, 6 },{ 7, 8, 9 }};
        leet54 so = new leet54();
        List = (ArrayList<Integer>) so.spiralOrder(matrix);
        System.out.println(List);
    }

}

class leet54{
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> List = new ArrayList<Integer>();
        int left = 0, top = 0;
        int bottom = matrix.length-1, right = matrix[0].length-1;
        int total =  matrix.length*matrix[0].length;
        int s  = total;
        while (total>=1){
            if(List.size()<s){
                for(int i = left;i<=right;i++){
                    List.add(matrix[top][i]);
                    total--;
                }
                top++;}
            if(List.size()<s){
                for(int i = top;i<=bottom;i++){
                    List.add(matrix[i][right]);
                    total--;
                }
                right--;}
            if(List.size()<s){
                for(int i = right; i>= left; i --){
                    List.add(matrix[bottom][i]);
                    total--;
                }
                bottom--;}
            if(List.size()<s){
                for(int i = bottom;i>=top;i--){
                    List.add(matrix[i][left]);
                    total--;
                }
                left++;}

        }
        return List;
    }
}