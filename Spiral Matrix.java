public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null) return null;
        if (matrix.length == 0) return res;


        int row = matrix.length;
        int col = matrix[0].length;
        int index = 0;
        getSpiralOrder(row, col, index,matrix, res);
        return res;
        
    }
    public void getSpiralOrder(int row, int col, int k, int[][] mat, ArrayList<Integer> res) {
        if (row <= 0 || col <= 0) return;//
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                res.add(mat[k][k+i]);
            }
            return;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                res.add(mat[k + i][k]);
            }
            return;
        }
        
        //top right
        for (int i = 0; i < col - 1; i++)
            res.add(mat[k][k + i]);
        
        //right bottom
        for (int i = 0; i < row - 1; i++)
            res.add(mat[k + i][k + col - 1]);
        
        //bottom left
        for (int i = 0; i < col - 1; i++)
            res.add(mat[row  + k - 1][k + col - 1 - i]);
        
        //left top
        for (int i = 0; i < row - 1; i++)
            res.add(mat[k + row - 1 - i][k]);
        
        
        
        
        getSpiralOrder(row - 2, col - 2, k + 1, mat, res);
        
    }
}