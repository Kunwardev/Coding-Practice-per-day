package Leetcode;

public class CandyCrush {
    
    public int[][] candyCrush(int[][] board){
        int R = board.length;
        int C = board[0].length;
        boolean stable = false;
        
        while (!stable) {
            stable = true;
            
            // Step 1: Mark candies to be crushed (horizontally)
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C-2; c++) {
                    int value = Math.abs(board[r][c]);
                    if (value != 0 && 
                        value == Math.abs(board[r][c+1]) && 
                        value == Math.abs(board[r][c+2])) {
                        board[r][c] = board[r][c+1] = board[r][c+2] = -value;
                        stable = false;
                    }
                }
            }
            
            // Step 2: Mark candies to be crushed (vertically)
            for (int r = 0; r < R-2; r++) {
                for (int c = 0; c < C; c++) {
                    int value = Math.abs(board[r][c]);
                    if (value != 0 && 
                        value == Math.abs(board[r+1][c]) && 
                        value == Math.abs(board[r+2][c])) {
                        board[r][c] = board[r+1][c] = board[r+2][c] = -value;
                        stable = false;
                    }
                }
            }
            
            // Step 3: Crush marked candies
            if (!stable) {
                // Drop candies
                for (int c = 0; c < C; c++) {
                    int writeRow = R-1;
                    // Move from bottom to top
                    for (int r = R-1; r >= 0; r--) {
                        if (board[r][c] > 0) {
                            board[writeRow--][c] = board[r][c];
                        }
                    }
                    // Fill empty spaces with 0
                    while (writeRow >= 0) {
                        board[writeRow--][c] = 0;
                    }
                }
            }
        }
        
        return board;
    }
}
