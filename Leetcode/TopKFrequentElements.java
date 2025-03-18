package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    
    private List<Integer> function(int[] arr, int k){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num: arr)
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> freqMap.get(n1) - freqMap.get(n2));
        for(int n: freqMap.keySet()){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        for(int num: pq){
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,3,3,2,2};
        int k = 2;
        TopKFrequentElements tk = new TopKFrequentElements();
        System.out.println(tk.function(arr, k));
    }

}
