package February;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {

    public ArrayList<Integer> kLargest(int[] arr, int k) {
            // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(pq.remove());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 13, 9, 100, 17};
        KLargestElements k = new KLargestElements();
        System.out.println(k.kLargest(arr, 2));
    }

}