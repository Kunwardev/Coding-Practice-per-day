package March;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSizedSubArrayMax {
    
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        result.add(pq.peek());
        System.out.println(pq);
        pq.remove(arr[0]);
        for(int i=k;i<n;i++){
            pq.add(arr[i]);
            System.out.println(pq);
            result.add(pq.peek());
            pq.remove(arr[i-k+1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k =3;
        KSizedSubArrayMax p = new KSizedSubArrayMax();
        p.maxOfSubarrays(arr, k);
    }

}
