/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/


public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 ) return 0; 
        int cnt = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    cnt++;
                    visited[i][j] = 1;
                    dfs(i,j,grid,visited);
                }
            }
        }
        
        return cnt;
    }
    
    public void dfs(int r, int c, char[][] grid, int[][] visited) {
        //left
        if (valid(r,c-1, grid, visited)) {
            visited[r][c-1] = 1;
            dfs(r, c-1, grid, visited);
        } 
        //top
        if (valid(r-1,c, grid, visited)) {
            visited[r-1][c] = 1;
            dfs(r-1, c, grid, visited);
        } 
        
        //right
        if (valid(r,c+1, grid, visited)) {
            visited[r][c+1] = 1;
            dfs(r, c+1, grid, visited);
        } 
        
        //bot
        if (valid(r+1,c, grid, visited)) {
            visited[r+1][c] = 1;
            dfs(r+1, c, grid, visited);
        } 
    }
    
    public boolean valid(int r, int c, char[][] grid, int[][] visited) {
        if (r>=0 && r<grid.length && c>=0 && c<grid[0].length && visited[r][c] == 0 && grid[r][c] == '1') return true;
        return false;
    }
}