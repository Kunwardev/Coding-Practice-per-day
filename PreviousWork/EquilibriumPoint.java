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
public class EquilibriumPoint {
    
    private static int function(int[] arr){
        
        int length = arr.length;
        int left[] = new int [length];
        int right[] = new int[length];
        
         for(int i=1; i<length; i++){
             left[i] = arr[i] + arr[i-1];
             right[length-i-1] = arr[length-i] + arr[length-i-1];
         }
         
         int index;
         for(index = 0; index < length; index++)
             if(left[index] == right[index])
                 break;
         
         return index;
    }
    
    public static void main(String[] args) {
        int arr[] = new int[]{3,3,5,3,3};
        System.out.println(function(arr));
    }
    
}
