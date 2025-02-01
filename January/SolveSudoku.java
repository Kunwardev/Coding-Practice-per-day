package January;

public class SolveSudoku
{
    private static boolean isSafe(int[][] mat, int row, int col, int num)
    {
        for(int i=0;i<9;i++){
            if(mat[i][col] == num)
                return false;
        }
        for(int j=0;j<9;j++){
            if(mat[row][j] == num)
                return false;
        }
        int rowCount = row - (row%3);
        int colCount = col - (col%3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mat[rowCount+i][colCount+j] == num)
                    return false;
            }
        }
        return true;
    }
    
    private static boolean solveSudokuUtil(int[][] mat, int row, int col)
    {
        if(row == 8 && col == 9){
            return true;
        }
        if(col == 9){
            row++;
            col = 0;
        }
        if(mat[row][col] != 0){
            return solveSudokuUtil(mat, row, col+1);
        }
        for(int num=1;num<=9;num++){
            if(isSafe(mat, row, col, num)){
                mat[row][col] = num;
                if(solveSudokuUtil(mat, row, col+1))
                    return true;
                mat[row][col] = 0;
            }
        }
        return false;
    }
    
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solveSudokuUtil(mat, 0, 0);
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        solveSudoku(mat);
        for(int[] row: mat)
        {
            for(int j: row){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}