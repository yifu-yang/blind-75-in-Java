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
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1963 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] mark;
    int count =0;
    public int numIslands(char[][] grid) {
        mark = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(!mark[i][j]){
                   count+= dfs(i,j,grid,count);
                }
            }
        }
        return count;
    }

    int dfs(int i,int j,char[][] grid,int count){
        if(grid[i][j]=='0'){
            mark[i][j] = true;
            return 0;
        }
        mark[i][j] = true;
        if(i-1>=0&&!mark[i-1][j]){
            dfs(i-1,j,grid,count);
        }
        if(i+1<grid.length&&!mark[i+1][j]){
            dfs(i+1,j,grid,count);
        }
        if(j-1>=0&&!mark[i][j-1]){
            dfs(i,j-1,grid,count);
        }
        if(j+1<grid[0].length&&!mark[i][j+1]){
            dfs(i,j+1,grid,count);
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
