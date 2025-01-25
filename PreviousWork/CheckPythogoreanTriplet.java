/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

import java.util.HashMap;

/**
 *
 * @author DEV
 */
public class CheckPythogoreanTriplet {
    
    private static boolean checkTriplet(int arr[], int n) 
    { 
        int maximum = 0; 

        // Find the maximum element 
        for (int i = 0; i < n; i++) 
        { 
            maximum = Math.max(maximum, arr[i]); 
        } 

        // Hashing array 
        int []hash = new int[maximum + 1]; 

        // Increase the count of array elements 
        // in hash table 
        for (int i = 0; i < n; i++) 
            hash[arr[i]]++; 

        // Iterate for all possible a 
        for (int i = 1; i < maximum + 1; i++) 
        { 

            // If a is not there 
            if (hash[i] == 0) 
                continue; 

            // Iterate for all possible b 
            for (int j = 1; j < maximum + 1; j++)  
            { 

                // If a and b are same and there is only one a 
                // or if there is no b in original array 
                if ((i == j && hash[i] == 1) || hash[j] == 0) 
                    continue; 

                // Find c 
                int val = (int) Math.sqrt(i * i + j * j); 

                // If c^2 is not a perfect square 
                if ((val * val) != (i * i + j * j)) 
                    continue; 

                // If c exceeds the maximum value 
                if (val > maximum) 
                    continue; 

                // If there exists c in the original array, 
                // we have the triplet 
                if (hash[val] == 1)  
                { 
                    return true; 
                } 
            } 
        } 
    return false; 
    } 
    
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,4,6};
        System.out.println(checkTriplet(arr, arr.length));
    }
    
}
