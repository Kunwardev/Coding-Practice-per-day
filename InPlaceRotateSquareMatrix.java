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
public class InPlaceRotateSquareMatrix {
    
    private static void functionAntiClockwise(int[][] mat){
        int length = mat.length;
        for(int x=0; x<length/2; x++){
            for(int y=x; y<length-x-1; y++){
                int temp = mat[x][y];
                mat[x][y] = mat[y][length-1-x];
                mat[y][length-1-x] = mat[length-1-x][length-1-y];
                mat[length-1-x][length-1-y] = mat[length-1-y][x];
                mat[length-1-y][x] = temp;
            }
        }
    }
    
    private static void functionClockwise(int[][] mat){
        int length = mat.length;
        for(int x=0; x<length/2; x++){
            for(int y=x; y<length-x-1; y++){
                int temp = mat[x][y];
                mat[x][y] = mat[length-1-y][x];
                mat[length-1-y][x] = mat[length-1-x][length-1-y];
                mat[length-1-x][length-1-y] = mat[y][length-1-x];
                mat[y][length-1-x] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] mat = new int[][]{ 
        { 1, 2, 3, 4 }, 
        { 5, 6, 7, 8 }, 
        { 9, 10, 11, 12 }, 
        { 13, 14, 15, 16 } 
    }; 
        functionAntiClockwise(mat);
        for(int i=0;i<mat.length; i++){
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
        functionClockwise(mat);
        for(int i=0;i<mat.length; i++){
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
}
