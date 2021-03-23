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
public class Kadane {
    
    private static int function(int[] arr){
        int maxSumSoFar = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxSumSoFar = Math.max(arr[i], arr[i]+maxSumSoFar);
            maxSum = Math.max(maxSum, maxSumSoFar);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,-2,5};
        System.out.println(function(arr));
    }
    
}
