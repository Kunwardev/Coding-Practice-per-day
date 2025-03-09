package Leetcode;

public class SpiralMatrixTraverse {
    
    private void function(int[][] A, int n, int m){
        int left = 0, right = n-1, top = 0, bottom = m-1;
        while(left <= right && top <= bottom){
            for(int j=left;j<=right;j++){
                System.out.print(A[top][j]+" ");
            }
            top++;
            for(int i=top;i<=bottom;i++){
                System.out.print(A[i][right]+" ");
            }
            right--;
            if(top <= bottom)
            {
                for(int j=right;j>=left;j--){
                    System.out.print(A[bottom][j]+" ");
                }
            }
            bottom--;
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    System.out.print(A[i][left]+" ");
                }
            }
            left++;
        }
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]
        {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};
        SpiralMatrixTraverse s = new SpiralMatrixTraverse();
        s.function(arr, 3, 3);
    }

}
