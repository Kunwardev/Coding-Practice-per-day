/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author kunwar
 */
public class LargestNumberFormedFromArray {
    class comparer implements Comparator<String>{
        
        public int compare(String a, String b){
            String ab = a+b;
            String ba = b+a;
            return -1 * ab.compareTo(ba);
        }
    }
    
    String printLargest(String[] arr) {
        // code here
        comparer c = new comparer();
        Arrays.sort(arr, c);
        for(String s: arr)
            System.out.print(s);
        return "";
    }
    
    public static void main(String[] args) {
        LargestNumberFormedFromArray l = new LargestNumberFormedFromArray();
        String[] arr = new String[]{"10", "5"};
        System.out.println(l.printLargest(arr));
    }
    
}
