//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1222 👎 0


package oj_5th.leetcode.editor.cn;
/*
*   [200] number-of-islands
*   2021-07-08 23:12:54
*/
public class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }
    //[200] number-of-islands
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int ret = 0;
        int[][] flags = new int[grid.length][grid[0].length];//0表示没走过，1表示走过了


        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(flags[i][j]==0 ){
                    if( grid[i][j] == '1'){
                        flags = dfs(i, j, grid, flags);
                        ret++;
                    }else{
                        flags[i][j]=1;
                    }
                }

            }
        }
        return ret;
    }

    public int[][] dfs(int i, int j, char[][] grid, int[][] flags) {
        boolean isIland = false;
        if ((i >= 0 && i < grid.length) || (j >= 0 && j < grid[0].length)) {
            return flags;
        }
        if (flags[i][j] == 1 || grid[i][j] == '0') {
            return flags;
        }
        flags[i][j] = 1;

        if (grid[i][j] == '0') {
            return flags;
        }

        flags = dfs(i - 1, j, grid, flags);
        flags = dfs(i + 1, j, grid, flags);
        flags = dfs(i, j - 1, grid, flags);
        flags = dfs(i, j + 1, grid, flags);

        return flags;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}