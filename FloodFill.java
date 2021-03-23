/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Recursion;

/**
 *
 * @author DEV
 */
public class FloodFill {
    
    private static void function(int[][] arr, int x, int y, int newC){
        int prevC = arr[x][y];
        functionUtil(arr, x, y, prevC, newC);
    }

    private static void functionUtil(int[][] arr, int x, int y, int prevC, int newC) {
        if(x > 0 && y > 0 && x < arr.length && y < arr[0].length){
            if(arr[x][y] != prevC){
                return;
            }
            arr[x][y] = newC;
            functionUtil(arr, x+1, y, prevC, newC);
            functionUtil(arr, x-1, y, prevC, newC);
            functionUtil(arr, x, y+1, prevC, newC);
            functionUtil(arr, x, y-1, prevC, newC);
        }
    }
    
    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1}, 
                    {1, 1, 1, 1, 1, 1, 0, 0}, 
                    {1, 0, 0, 1, 1, 0, 1, 1}, 
                    {1, 2, 2, 2, 2, 0, 1, 0}, 
                    {1, 1, 1, 2, 2, 0, 1, 0}, 
                    {1, 1, 1, 2, 2, 2, 2, 0}, 
                    {1, 1, 1, 1, 1, 2, 1, 1}, 
                    {1, 1, 1, 1, 1, 2, 2, 1}, 
                    }; 
    int x = 4, y = 4, newC = 3; 
        function(screen, x, y, newC);
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen[0].length; j++){
                System.out.print(screen[i][j]+" ");
            }System.out.println();
        }
    }
    
}
