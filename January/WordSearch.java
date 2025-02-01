package January;

class Result
{
    static boolean result;
    
    public Result()
    {
        result = false;
    }
}

public class WordSearch {
    
    private static boolean isSafe(int row, int col, int rowLength, int colLength){
        return row >= 0 && row < rowLength && col >= 0 && col < colLength;
    }

    public static boolean isWordExist(char[][] mat, String word) {
        // Code here
        int rowLength = mat.length;
        int colLength = mat[0].length;
        char[] wordArray = word.toCharArray();
        boolean[][] visited = new boolean[rowLength][colLength];
        for(int row = 0; row < rowLength; row++)
        {
            for(int col = 0; col < colLength; col++)
            {
                if(isWordExistUtil(mat, row, col, wordArray, 0, visited))
                    return true;
                }
            }
        return false;
    }
                    
     private static boolean isWordExistUtil(char[][] mat, int row, int col, char[] wordArray, int i, boolean[][] visited) {
        int[] rowMove = new int[] {-1, 0, 1, 0};
        int[] colMove = new int[] {0, -1, 0, 1};
        if(i == wordArray.length)
            return true;
        if(mat[row][col] == wordArray[i]){
            visited[row][col] = true;
            for(int k=0;k<4;k++){
                if(isSafe(row+rowMove[k], col+colMove[k], mat.length, mat[0].length)){
                    if(!visited[row+rowMove[k]][col+colMove[k]])
                        if(isWordExistUtil(mat, row+rowMove[k], col+colMove[k], wordArray, i+1, visited)){
                            return true;
                    }
                }
            }
            visited[row][col] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {{ 'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
            {'a', 'd', 'e', 'e'}};
        System.out.println(isWordExist(grid, "sabfdk"));
    }

}