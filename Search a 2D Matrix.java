/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
	//bs return index. when s>e, s is the insert position. s belongs [0, len_array]
    //bs, in an array, insert index when s > e is at s, how to prove? find all the cases. 1: s = e; 2: s + 1 = e....
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bs(0, matrix.length-1, matrix, target);
        if (row < matrix.length && matrix[row][0] == target) return true;//hit
        if (row == 0) return false;
        else row = row - 1;
        return bs(0, matrix[0].length-1, row, matrix, target);
    }
    
    public int bs(int s, int e, int[][] matrix, int target) {
        int mid = (s + e)/2;
        if (s>e) return s;//this is the insert positon
        if (matrix[mid][0] == target) {
            return mid;
        } else if (matrix[mid][0] > target) {
            return bs(s, mid-1, matrix, target);
        } else return bs(mid+1, e, matrix, target);
    }
    
    public boolean bs(int s, int e, int row, int[][] matrix, int target) {
        int mid = (s + e)/2;
        if (s>e) return false;
        if (matrix[row][mid] == target) {
            return true;
        } else if (matrix[row][mid] > target) {
            return bs(s, mid-1, row, matrix, target);
        } else return bs(mid+1, e ,row, matrix, target);
    }
}