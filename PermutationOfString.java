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
public class PermutationOfString {
    
    private static void function(char[] arr, int n){
        int i = 0;
        functionUtil(arr, n, i);
    }

    private static void functionUtil(char[] arr, int n, int i) {
        if(i == n){
            System.out.println(new String(arr));
            return;
        }
        for(int j=i; j<n;j++){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            functionUtil(arr, n, i+1);
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        String str = "ABC";
        function(str.toCharArray(), 3);
    }
    
}
