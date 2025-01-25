/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author DEV
 */
public class ConvertMatrixIntoMatrixOfAnotherDimension {
    
    private static void function(int[][] mat, int A, int B){
        int N = mat.length;
        int M = mat[0].length;
        int idx = 0;
        if(N*M != A*B)
            return;
        int[][] res = new int[A][B];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                res[idx / B][idx % B] = mat[i][j]; 
                idx++;
            }
        }
        for(int i=0;i<A;i++){
            for(int j=0;j<B;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4, 5, 6 } }; 
        int A = 2; 
        int B = 3; 
        function(mat, A, B);
    }
    
}
