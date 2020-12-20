/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Misc;

/**
 *
 * @author DEV
 */
public class CountPermutationWithNoNumberAtOriginalPosition {
    
    private static int function(int n){
        int[] result = new int[n+1];
        result[0] = result[1] = 0;
        result[2] = 1;
        for(int i = 3; i <= n; i++){
            result[i] = (i-1) * (result[i-1] + result[i-2]);
            
        }
        return result[n];
    }
    
    public static void main(String[] args) {
        System.out.println(function(4));
        
    }
    
}
