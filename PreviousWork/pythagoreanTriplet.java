/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

import java.util.Arrays;

/**
 *
 * @author DEV
 */
public class pythagoreanTriplet {
    
    private static void function(int[] arr){
        Arrays.sort(arr);
        int length = arr.length;
        for(int i=0;i<length;i++){
            int k=length-1, j = i+1;
            while(j < k){
                if(arr[k]*arr[k] == arr[i]*arr[i] + arr[j]*arr[j]){
                    System.out.println(arr[i] +" " + arr[j] + " " + arr[k]);
                    return;
                }
                j++;k--;
            }
        }
        System.out.println("Nothing found");
    }
    
    public static void main(String[] args) {
        int[] arr = {3,5,8};
        function(arr);
    }
    
}
