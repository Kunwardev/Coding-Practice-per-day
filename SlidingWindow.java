/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Misc;

/**
 *
 * @author kunwar
 */
public class SlidingWindow {
    
    private static int function(int[] arr, int k){
        int wL = 0, wR = 0, windowCount = 1, sum = 0, maxSum = 0;
        while(wR < arr.length){
            if(wR - wL < k){
                sum += arr[wR];
                wR++;
            } else{
                sum -= arr[wL];
                wL++;
            }
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{100,200,300,400,100,800};
        System.out.println(function(arr, 2));
    }
    
}
