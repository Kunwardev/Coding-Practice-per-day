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
public class NumberOfPaths {
    
    private static int function(int m, int n){
        if(m == 1 || n == 1)
            return 1;
        return function(m-1, n) + function(m, n-1);
    }
    
    public static void main(String[] args) {
        System.out.println(function(3, 3));
    }
    
}
