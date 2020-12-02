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
public class SpirallyTraversingMatrix {
    
    private static void function(int[][] mat){
        int row_max = mat.length, col_max = mat[0].length, row = 0, col = 0, k;
        while(row < row_max && col < col_max){
            for(k=col; k<=col_max-1; k++){
                System.out.print(mat[row][k] + " ");
            }row++;
            for(k=row; k<=row_max-1; k++){
                System.out.print(mat[k][col_max-1] + " ");
            }col_max--;
            if(row < row_max){
                for(k=col_max-1; k >= col; k--){
                    System.out.print(mat[row_max-1][k] + " ");
                }row_max--;
            }
            if(col < col_max){
                for(k=row_max-1; k >= row;k--){
                    System.out.print(mat[k][col] + " ");
                }col++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] mat = new int[][]
                      {{ 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 }};
        function(mat);
    }
    
}
