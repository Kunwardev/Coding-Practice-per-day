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
public class ConvertArrayIntoZigZag {
    
    private static void function(int[] arr){
        int length = arr.length;
        // a < b > c < d
        for(int i=1; i<length; i++){
            if(i%2 == 0) {
                if(arr[i-1] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
                if(i != length-1){
                    if(arr[i] > arr[i+1]){
                        int temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                    }
                }
            } else {
                if(arr[i-1] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
                if(i != length-1){
                    if(arr[i+1] > arr[i]){
                        int temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
    //    int[] arr = new int[]{1, 4, 3, 2};
        int[] arr = new int[]{4, 3, 7, 8, 6, 2, 1};
        function(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    
}
