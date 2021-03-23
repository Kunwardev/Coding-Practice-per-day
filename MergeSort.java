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
public class MergeSort {
    
    private static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i=0; i< n1; i++){
            L[i] = arr[i+l];
        }
        for(int j=0; j<n2; j++){
            R[j] = arr[mid+1+j];
        }
        
        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < n1){
            arr[k] = L[i];
            i++;k++;
        }
        
        while(j < n2){
            arr[k] = R[j];
            j++;k++;
        }
        
    }
    
    private static void sort(int[] arr, int l, int r){
        if(l < r){
            int mid = (l+r)/2;
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7};
        sort(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    
}
