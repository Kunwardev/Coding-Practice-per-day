/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

import java.util.PriorityQueue;

/**
 *
 * @author DEV
 */
public class KthSmallestElement {
    
    private static int functionWithPriorityQueue(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: arr){
            pq.add(i);
        }
        for(int i=0;i<k-1;i++)
            pq.poll();
        return pq.poll();
    }
    
    private static int partition(int[] arr, int l, int r){
        int x = arr[r], i = l;
        for(int j=l; j<r;j++){
            if(x >= arr[j]){
                int p = arr[i];
                arr[i] = arr[j];
                arr[j] = p;
                i++;
            }
        }
        int p = arr[r];
        arr[r] = arr[i];
        arr[i] = p;
        return i;
    }
    
    private static int functionWithQuickSortPartition(int[] arr,int l, int r, int k){
        if(k > 0 && k<= r-l+1){
            int pos = partition(arr, l, r);
            if(pos-l == k-1)
                return arr[pos];
            else if(pos-l > k-1){
                return functionWithQuickSortPartition(arr, l, pos-1, k);
            }
            return functionWithQuickSortPartition(arr, pos+1, r, k-pos+l-1);
        }
        return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 2, 6, 5};
        System.out.println(functionWithPriorityQueue(arr, 3));
        System.out.println(functionWithQuickSortPartition(arr, 0, arr.length-1, 3));
    }
    
}
