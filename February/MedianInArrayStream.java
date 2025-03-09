package February;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInArrayStream {
    
    private ArrayList<Double> getMedian(int[] arr){
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());
        ArrayList<Double> result = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(maxHeap.isEmpty() || arr[i] <= maxHeap.peek())
                maxHeap.add(arr[i]/1.0);
            else
                minHeap.add(arr[i]/1.0);
            if(maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.remove());
            } else if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.remove());
            }
            if(maxHeap.size() > minHeap.size()){
                result.add(maxHeap.peek());
            } else{
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MedianInArrayStream m = new MedianInArrayStream();
        int[] arr = new int[]{5,15, 1, 3, 2, 8};
        System.out.println(m.getMedian(arr));
    }

}
