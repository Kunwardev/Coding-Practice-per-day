package April;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int i, j;
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class FloodFill {
    
    private boolean isSafe(int[][] mat, int i, int j, int oldColor, boolean[][]visited){
        if(i<0||i>=mat.length||j<0||j>=mat[0].length||visited[i][j]||mat[i][j] != oldColor)
            return false;
        return true;
    }

    private void fill(int[][] mat, int sx, int sy, int newColor){
        Queue<Pair> q = new LinkedList<>();
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int oldColor = mat[sx][sy];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        q.offer(new Pair(sx, sy));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            visited[temp.i][temp.j] = true;
            mat[temp.i][temp.j] = newColor;
            for(int i=0;i<4;i++){
                int r = temp.i + dir[i][0];
                int c = temp.j + dir[i][1];
                if(isSafe(mat, r, c, oldColor, visited)){
                    q.offer(new Pair(r, c));
                }
            }
        }
    }
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();

        // Test case 1: Basic test with a small matrix
        int[][] mat1 = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sx1 = 1, sy1 = 1, newColor1 = 2;
        floodFill.fill(mat1, sx1, sy1, newColor1);
        System.out.println("Test case 1: " + Arrays.deepToString(mat1));

        // Test case 2: Test with a larger matrix
        int[][] mat2 = {
            {0, 0, 0},
            {0, 1, 1},
            {1, 1, 0}
        };
        int sx2 = 1, sy2 = 1, newColor2 = 3;
        floodFill.fill(mat2, sx2, sy2, newColor2);
        System.out.println("Test case 2: " + Arrays.deepToString(mat2));

        // Test case 3: Test with no change (newColor is the same as oldColor)
        int[][] mat3 = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sx3 = 0, sy3 = 0, newColor3 = 1;
        floodFill.fill(mat3, sx3, sy3, newColor3);
        System.out.println("Test case 3: " + Arrays.deepToString(mat3));
    }

}
