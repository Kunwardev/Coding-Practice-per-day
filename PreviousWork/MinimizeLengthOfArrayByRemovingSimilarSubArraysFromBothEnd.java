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
public class MinimizeLengthOfArrayByRemovingSimilarSubArraysFromBothEnd {
    
    private static int function(int[] arr){
        int front = 0, end = arr.length-1;
        while(front < end){
            int x = arr[front];
            if(arr[front] != arr[end])
                break;
            while(arr[front] == x && front < end)
                front++;
            while(arr[end] == x && front < end)
                end--;
        }
        return (end - front + 1);
    }
    
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 3, 1, 2, 2, 1 }; 
        System.out.println(function(arr));
    }
    
}
