/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            if (i == 0) dp[i][0] = grid[i][0];
            else dp[i][0] = grid[i][0] + dp[i-1][0]; 
        }
        
        for (int i=0; i<grid[0].length; i++) {
            if (i == 0) dp[0][i] = grid[0][i];
            else dp[0][i] = grid[0][i] + dp[0][i-1]; 
        }
        
        for (int i =1; i<grid.length; i++) {
            for (int j=1; j<grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}