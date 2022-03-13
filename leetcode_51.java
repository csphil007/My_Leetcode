package leetcode;

import java.util.*;

public class leetcode_51 {
    /*
    八皇后
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>  res= new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> colunms = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        return res;
    }
    public void backtrack(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diag1, Set<Integer> diag2){
        if(row == n){
            List<String> board = generateBoard(queens,n);
            res.add(board);
        }
        else {
            for(int i =0; i<n;i++){
                if(columns.contains(i)){
                    continue;
                }
                int diag11 = row-i;
                if(diag1.contains(diag11)){
                    continue;
                }
                int diga22= row+i;
                if(diag2.contains(diga22)){
                    continue;
                }
                queens[row] =i;
                columns.add(i);
                diag1.add(i);
                diag2.add(i);
                backtrack(res, queens, n, row + 1, columns, diag1, diag2);
                queens[row] = -1;
                columns.remove(i);
                diag1.remove(diag11);
                diag2.remove(diga22);



            }

        }

    }
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
