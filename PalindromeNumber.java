/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Recursion;

/**
 *
 * @author kunwar
 */
public class PalindromeNumber {
    
    private static int function(int n){
        int dupNum = n;
        return functionUtil(n, dupNum);
    }
    
    private static int functionUtil(int num, int dupNum) {
        if(num == 0){
            return dupNum;
        } else{
            dupNum = functionUtil(num / 10, dupNum);
        }
        if(num % 10 == dupNum % 10){
            return dupNum / 10;
        } else{
            return -1;
        }
    }
    
    public static void main(String[] args) {
        int n = 1221;
        System.out.println(function(n));
        int m = 1122;
        System.out.println(function(m));
    }
    
}
