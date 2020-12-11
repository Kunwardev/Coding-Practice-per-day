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
public class MaxDifferenceBetween2Index {
    
    private static int function(int[] arr){
        int index_1 = 0;
        for(int i=arr.length-1;i>=0; i--){
            if(arr[index_1] != arr[i]){
                index_1 = i;
                break;
            }
        }
        int index_2 = arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(arr[index_2] != arr[i]){
                index_2 = arr.length - i - 1;
                break;
            }
        }
        return Math.max(index_1, index_2);
    }
    
    public static void main(String[] args) {
         int []a = { 1, 2, 3, 2, 3 }; 
         System.out.println(function(a));
    }
    
}
