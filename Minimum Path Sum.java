/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] table = new int[grid.length][grid[0].length];
        table[0][0] = grid[0][0];
        for (int i=1; i<grid.length; i++) {
            table[i][0] = grid[i][0] + table[i-1][0];
        }
        
        for (int i=1; i<grid[0].length;i++) {
            table[0][i] = grid[0][i] + table[0][i-1]; 
        }
        
        for (int i=1; i< grid.length;i++) {
            for (int j=1; j<grid[0].length;j++) {
                table[i][j] = grid[i][j] + Math.min(table[i-1][j], table[i][j-1]);
            }
        }
        
        return table[grid.length-1][grid[0].length-1];
    }
}