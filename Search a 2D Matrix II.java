/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/


public class Solution {
	//no logn*logn solution 
    //1:n2 bf
    //2:nlogn bs
    //3:n+n tricky, start from right top, recur or inter, each time remove one row or one col
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length-1;
        return search(matrix, r, c, target);
    }
    
    public boolean search(int[][] matrix, int r, int c, int target) {
        if (r>= matrix.length || c < 0) return false;
        if (matrix[r][c] == target) return true;
        else if (matrix[r][c] < target) return search(matrix, r+1, c, target);
        else return search(matrix, r, c-1, target);
    }
}