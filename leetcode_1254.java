package leetcode;
/*
统计封闭岛屿的数目
有一个二维矩阵 grid，每个位置要么是陆地（记号为0 ）要么是水域（记号为1 ）。
我们从一块陆地出发，每次可以往上下左右4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
如果一座岛屿完全由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
请返回封闭岛屿的数目。
 */
public class leetcode_1254 {
}

class lee_1254 {
    int width =0;
    int length =0;
    int res =0;
    public int closedIsland(int[][] grid) {
        width = grid.length;
        length = grid[0].length;
        for(int i = 0;i<width;i++){
            for(int j = 0;j < length; j ++){
                if(grid[i][j] == 0)
                    res+=dfs(grid,i,j);
            }
        }
        return res;
    }
    /* 图的深度优先遍历,即访问该顶点的上下左右顶点 */
    private int dfs(int[][] grid, int i, int j) {
        /* 如果上下左右挨边则说明不是封闭岛屿 */
        if(i <0 || j<0 || i>=width || j>=length)return 0;
        /* 反之则说明该方向没有挨边 */
        if(grid[i][j] == 1 )return 1;
        grid[i][j] = 1 ;
        return dfs(grid, i - 1, j) & dfs(grid, i + 1, j)
                & dfs(grid, i, j - 1) & dfs(grid, i, j + 1);
    }
}