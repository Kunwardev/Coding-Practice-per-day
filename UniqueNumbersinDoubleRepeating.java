/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author kunwar
 */
public class UniqueNumbersinDoubleRepeating {
    
    // Using XOR
    private static void function(int[] arr){
        int length = arr.length;
        int sum = 0;
        for(int i=0; i<length; i++){
            sum = sum ^ arr[i];
        }
        System.out.println(sum);
        // Find the Rightmost Set Bit
        sum = sum & (-sum);
        
        int sum1 = 0, sum2 = 0;
        
        for(int i=0; i<length; i++){
            if((arr[i] & sum) > 0){
                sum1 = sum1 ^ arr[i];
            } else{
                sum2 = sum2 ^ arr[i];
            }
        }
        System.out.println("2 Unique Numbers Present: " + sum1 + " " + sum2);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 9, 11, 2, 3, 11};
        function(arr);
    }
    
}
