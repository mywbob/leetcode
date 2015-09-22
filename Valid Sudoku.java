/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        //check row
        for (int i=0; i<board.length; i++) {
            set.clear();
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!set.contains(board[i][j]) && board[i][j] >= '1' && board[i][j] <= '9') {
                        set.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        //check col
        for (int i=0; i<board.length; i++) {
            set.clear();
            for (int j=0; j<board[0].length; j++) {
                if (board[j][i] != '.') {
                    if (!set.contains(board[j][i]) && board[j][i] >= '1' && board[j][i] <= '9') {
                        set.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        set.clear();
        
        
        //check 9 small mats
        for (int offsi=0; offsi<3; offsi++) {
            for (int offsj=0; offsj<3; offsj++) {
                set.clear();
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        if (board[i+3*offsi][j+3*offsj] != '.') {
                            if (!set.contains(board[i+3*offsi][j+3*offsj]) && board[i+3*offsi][j+3*offsj]>='1' && board[i+3*offsi][j+3*offsj]<='9') {
                                set.add(board[i+3*offsi][j+3*offsj]);
                            
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return true;

    }
	
}