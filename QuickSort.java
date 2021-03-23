/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Sorting;

/**
 *
 * @author DEV
 */
public class QuickSort {
    
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        
        for(int j=low; j<high; j++){
            
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
    
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        
        return i+1;
    }
    
    private static void sort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{10, 7, 8, 9, 1, 5};
        sort(arr, 0, arr.length-1);
        for(int j: arr){
            System.out.print(j+"  ");
        }
    }
    
}
