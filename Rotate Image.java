/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/




public class Solution {
    //1: o(mn) space
    //2: o(1) space, layer by layer
    public void rotate(int[][] matrix) {
        for (int layer = 0; layer < matrix.length / 2; layer++) {
			for (int index = layer; index < matrix.length - layer - 1; index++) {
				int temp = matrix[layer][index];
				matrix[layer][index] = matrix[matrix.length - index - 1][layer];
				matrix[matrix.length - index - 1][layer] = matrix[matrix.length - layer - 1][matrix.length - index - 1];
				matrix[matrix.length - layer - 1][matrix.length - index - 1] = matrix[index][matrix.length - layer - 1];
				matrix[index][matrix.length - layer - 1] = temp;
			}
		}
    }
}