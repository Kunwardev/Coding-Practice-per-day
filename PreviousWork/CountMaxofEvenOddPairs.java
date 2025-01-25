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
public class CountMaxofEvenOddPairs {
    
    private static int function(int[] arrA, int[] arrB){
        int length = arrA.length;
        int totalPairs = length * length;
        int oddPairs = 0, evenPairs = 0;
        int evenCount = 0;
        for(int i=0;i<length;i++){
            if(arrA[i] % 2 == 0){
                evenPairs += length;
                evenCount++;
            }
        }
        for(int i=0;i<length;i++){
            if(arrB[i] % 2 == 0){
                evenPairs += (length - evenCount);
            }
        }
        oddPairs = totalPairs - evenPairs;
        return Math.max(evenPairs, oddPairs);
    }
    
    public static void main(String[] args) {
        int[] arrA = {1,5,9};
        int[] arrB = {1,7,3};
        System.out.println(function(arrA, arrB));
    }
    
}
