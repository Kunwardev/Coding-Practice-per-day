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
public class HeapSort {
    
    private static int parent(int n){
        return (n/2);
    }
    
    private static int leftChild(int n){
        return 2*n + 1;
    }

    private static int rightChild(int n){
        return 2*n + 2;
    }
    
    private static void minHeapify(int[] arr, int n, int i){
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        
        if(left < n && arr[left] > arr[largest])
            largest = left;
        
        if(right < n && arr[right] > arr[largest])
            largest = right;
        
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            minHeapify(arr, n, largest);
        }
        
    }
    
    private static void sort(int[] arr){
        int length = arr.length;
        for(int i=length/2; i>=0;i--){
            minHeapify(arr, length, i);
        }
        for(int i=length-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            minHeapify(arr, i, 0);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7};
        sort(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    
}
