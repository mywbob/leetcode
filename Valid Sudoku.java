/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        //check row
        for (int i=0; i<9; i++) {
            set.clear();
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }
        
        //check col
        for (int i=0; i<9; i++) {
            set.clear();
            for (int j=0; j<9; j++) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                else set.add(board[j][i]);
            }
        }
        
        //check sub
        for (int offsetr = 0; offsetr < 3; offsetr++) {
            for (int offsetc = 0; offsetc < 3; offsetc++) {
                set.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i+3*offsetr][j+3*offsetc] == '.') continue;
                        if (set.contains(board[i+3*offsetr][j+3*offsetc])) return false;
                        else set.add(board[i+3*offsetr][j+3*offsetc]);
                    }
                }
            }
        }
        
        return true;
    }
	
}