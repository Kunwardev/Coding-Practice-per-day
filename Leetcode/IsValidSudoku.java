package Leetcode;

public class IsValidSudoku {
    
    private boolean isRowInValid(char[][] board, int i){
        int[] count = new int[10];
        for(int j=0;j<9;j++){
            if(board[i][j] == '.')
                continue;
            else{
                count[board[i][j]-'0']++;
                if(count[board[i][j]-'0'] > 1)
                    return true;
            }
        }
        return false;
    }

    private boolean isColInvalid(char[][] board, int j){
        int[] count = new int[10];
        for(int i=0;i<9;i++){
            if(board[i][j] == '.')
                continue;
            else{
                count[board[i][j]-'0']++;
                if(count[board[i][j]-'0'] > 1)
                    return true;
            }
        }
        return false;
    }

    private boolean isBoxInValid(char[][] board, int i, int j){
        int boxR = i-i%3;
        int boxC = j-j%3;
        int[] count = new int[10];
        for(int r = boxR; r<boxR+3; r++){
            for(int c = boxC; c<boxC+3; c++){
                if(board[r][c] == '.')
                    continue;
            else{
                count[board[r][c]-'0']++;
                if(count[board[r][c]-'0'] > 1)
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(isRowInValid(board, i) || isColInvalid(board, j) || isBoxInValid(board, i, j)){
                        return false;
                    }
            }
        }
        return true;
    }

}
