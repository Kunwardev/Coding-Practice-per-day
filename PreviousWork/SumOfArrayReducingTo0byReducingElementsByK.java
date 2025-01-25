/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author DEV
 */
public class SumOfArrayReducingTo0byReducingElementsByK {
    
//    According to the value of the sum, the following cases arise:
//
//    If sum = 0: No operation is required. Therefore, the answer is “Yes”.
//    If sum > 0: Sum can be reduced to 0 only if sum is a multiple of K. If sum is not a multiple of K, print “No”. Otherwise, print “Yes”.
//    If sum < 0: Simply print “No”.

    
    private static boolean function(int[] arr, int K){
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        if(sum >= 0){
            return (sum % K) == 0;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int arr[]= new int[]{-3, 2, -1, 5, 1};
        int K=2;
        System.out.println(function(arr, K));
        int arr1[] = new int[]{1, -6, 2, 2};
        K = 1;
        System.out.println(function(arr1, K));
    }
    
}
