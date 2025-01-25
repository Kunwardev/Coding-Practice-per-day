/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author kunwar
 */
public class FindMedian {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.insertHeap(7);
        s.insertHeap(9);
        s.insertHeap(6);
        s.insertHeap(8);
        s.insertHeap(5);
        System.out.println(s.getMedian());
        s.insertHeap(4);
        System.out.println(s.getMedian());
        
    }
}

class reverseCompare implements Comparator<Integer>{

    @Override
    public int compare(Integer t, Integer t1) {
        return t1.compareTo(t);
    }
}

class Solution
{
    static reverseCompare reverseC = new reverseCompare();
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(reverseC);
    
    public static void insertHeap(int x)
    {
        // add your code here
        if(minHeap.size() == 0 || x > minHeap.peek())
            minHeap.add(x);
        else
            maxHeap.add(x);
        balanceHeaps();
    }
    
     // Function to balance Heaps
    public static void balanceHeaps()
    {
       // add your code here
        PriorityQueue<Integer> bigger = (maxHeap.size() > minHeap.size()) ? maxHeap : minHeap;
        PriorityQueue<Integer> smaller = (minHeap.size() > maxHeap.size()) ? minHeap : maxHeap;
        if(bigger.size() - smaller.size() >= 2){
            smaller.add(bigger.poll());
        }
    }
    
    // function to getMedian
    public static double getMedian()
    {
        // add your code here
        PriorityQueue<Integer> bigger = (maxHeap.size() > minHeap.size()) ? maxHeap : minHeap;
        PriorityQueue<Integer> smaller = (minHeap.size() > maxHeap.size()) ? minHeap : maxHeap;
        if(bigger.size() == smaller.size()){
            return (double)(bigger.peek() + smaller.peek()) / 2;
        }
        return bigger.peek();
    }
    
    
}