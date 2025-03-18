package Leetcode;

import java.util.PriorityQueue;

public class KthLargestElement {
    
    private static int kthLargest(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i: arr)
            pq.add(i);
        System.out.println(pq.poll());
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,7,3,9};
        kthLargest(arr);
    }

}
