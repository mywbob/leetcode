/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/



public class Solution {
    //1: o(mn) space
    //2: o(m+n) space
    //3: o(1) space, use first row and col
    public void setZeroes(int[][] matrix) {
        boolean firstRowHas0 = false;
        boolean firstColHas0 = false;
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) firstRowHas0 = true;
        }
        for (int i=0; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) firstColHas0 = true;
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length;j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstRowHas0) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (firstColHas0) {
            for (int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        
    }
}