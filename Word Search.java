/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

////return as soon as a match is found

public class Solution {
	boolean res = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {//first char match
                    visited[i][j] = true;
                    dfs(i, j, word.substring(1, word.length()), board, visited);
                    visited[i][j] = false;
                    if (res == true) return true;
                }
            }
        }
        return false;
    }
    
    public void dfs(int r, int c, String str, char[][] board, boolean[][] visited) {
        if (str.length() == 0) {
            res = true;
            return;
        }
        if (res == true) return;
        //top
        if (valid(r-1, c, str, board, visited)) {
            visited[r-1][c] = true;
            dfs(r-1,c,str.substring(1, str.length()), board, visited);
            visited[r-1][c] = false;
        }
        //right
        if (valid(r, c+1, str, board, visited)) {
            visited[r][c+1] = true;
            dfs(r,c+1,str.substring(1, str.length()), board, visited);
            visited[r][c+1] = false;
        }
        //bot
        if (valid(r+1, c, str, board, visited)) {
            visited[r+1][c] = true;
            dfs(r+1,c,str.substring(1, str.length()), board, visited);
            visited[r+1][c] = false;
        }
        //left
        if (valid(r, c-1, str, board, visited)) {
            visited[r][c-1] = true;
            dfs(r,c-1,str.substring(1, str.length()), board, visited);
            visited[r][c-1] = false;
        }
        
    }
    
    public boolean valid(int r, int c, String s, char[][] board, boolean[][] visited) {
        if (r>=0 && r<board.length && c>=0 && c<board[0].length && visited[r][c] == false && s.charAt(0)== board[r][c]) return true;
        return false;
    }
	
	
	
	
	
	
	//old
    boolean[] res = new boolean[1];
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i< board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    dfs(i, j, word.substring(1, word.length()), board, visited, res);
                    visited[i][j] = false;
                    if (res[0] == true) return true;
                }
            }
        }
        
        return res[0];
    }
    
    
    public void dfs(int r, int c, String word, char[][] board, boolean[][] visited, boolean[] res) {
        if (word.length() == 0) {
            res[0] = true;
            return;
        }
        
        if (res[0] == true) return;//return as soon as a match is found
        
        //left
        if (valid(r, c-1, board, visited,  word)) {
            visited[r][c-1] = true;
            dfs(r, c-1, word.substring(1, word.length()), board, visited, res);
            visited[r][c-1] = false;
        }
        
        //down
        if (valid(r+1, c, board,visited,word)) {
            visited[r+1][c] = true;
            dfs(r+1, c, word.substring(1, word.length()), board,visited, res);
            visited[r+1][c] = false;
        }
        
        //right
        if (valid(r, c+1, board,visited,word)) {
            visited[r][c+1] = true;
            dfs(r, c+1, word.substring(1, word.length()), board,visited, res);
            visited[r][c+1] = false;
        }
        
        //top
        if (valid(r-1, c, board,visited,word)) {
            visited[r-1][c] = true;
            dfs(r-1, c, word.substring(1, word.length()), board,visited, res);
            visited[r-1][c] = false;
        }
        
        
    }
    
    
    public boolean valid(int r, int c, char[][] board, boolean[][] visited, String word) {//valid(not out of index and equal) and not visited
        if (r<0 || r>= board.length || c < 0 || c >= board[0].length) return false;
        if (visited[r][c] == true) return false;
        if (board[r][c] != word.charAt(0)) return false;
        return true;
    }
}