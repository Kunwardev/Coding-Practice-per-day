/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author DEV
 * Simple idea of the Kadane’s algorithm is to look for all positive contiguous
 * segments of the array (max_ending_here is used for this). And keep track of 
 * maximum sum contiguous segment among all positive segments (max_so_far is 
 * used for this).
 */
public class LargestSumContinousArray {
    
    private static int function(int[] arr){
        int max_so_far = 0, max_ending_here = 0;
        int index = 0, length = arr.length;
        for(index = 0; index < length; index++){
            max_ending_here += arr[index];
            if(max_ending_here > max_so_far){
                max_so_far = max_ending_here;
            }
            if(max_ending_here < 0){
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Max Sum Continous Array using Kadane Algorithms: " + function(arr));
    }
    
}
