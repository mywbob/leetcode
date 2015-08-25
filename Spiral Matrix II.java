public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] res = new int[n][n];
		if (n == 0) return res;
        int cnt = 1;
		int row = 0, col = 0;
		String direction = new String("1000");
		res[row][col] = 1;
		if (n ==1 ) return res;
		while (cnt < n * n) { 
			
			if (col < n - 1 && res[row][col+1] == 0 && direction.equals("1000")) {//right 1000
				col++;
				res[row][col] = ++cnt;
				if (!(col < n - 1 && res[row][col+1] == 0)) direction = "0100";
			}
			
			else if (row < n -1 && res[row + 1][col] == 0 && direction.equals("0100")) {//down 0100
				row++;
				res[row][col] = ++cnt;
				if (!(row < n -1 && res[row + 1][col] == 0)) direction = "0010";
			}
			
			else if (col > 0 && res[row][col-1] == 0 && direction.equals("0010")) {//left 0010
				col--;
				res[row][col] = ++cnt;
				if (!(col > 0 && res[row][col-1] == 0)) direction = "0001";
			}
			
			else {//top 0001
				if (row > 0 && res[row - 1][col] == 0 && direction.equals("0001")) {
				row--;
				res[row][col] = ++cnt;
				if (!(row > 0 && res[row - 1][col] == 0)) direction = "1000";
				}
			}

			
			
		}
		return res;
    }
}