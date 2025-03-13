package March;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[] traverse = {0, 1, -1};
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int liveNeighbor = 0;
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(!(traverse[i] == 0 && traverse[j] == 0)){
                            int r = row + traverse[i];
                            int c = col + traverse[j];
                            if(r >= 0 && r < rows && c >= 0 && c < cols && (Math.abs(board[r][c]) == 1)){
                                liveNeighbor++;
                            }
                        }
                    }
                }
                if((board[row][col] == 1) && (liveNeighbor < 2 || liveNeighbor > 3)){
                    board[row][col] = -1;
                }
                if(board[row][col] == 0 && liveNeighbor == 3){
                    board[row][col] = 2;
                }
            }
        }
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(board[row][col] <= 0){
                    board[row][col] = 0;
                }else{
                    board[row][col] = 1;
                }
            }
        }
    }
}
