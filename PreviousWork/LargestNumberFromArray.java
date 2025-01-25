/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DEV
 */

class comparer implements Comparator<String>{

    public int compare(String o1, String o2) {
        String XY = o1+o2;
        String YX = o2+o1;
        return XY.compareTo(YX) > 0 ? -1 : 1;
    }

    
}

public class LargestNumberFromArray {
    
    private static void function(int[] arr){
        ArrayList<String> ar = new ArrayList<>();
        for(int i: arr){
            ar.add(i+"");
        }
        Collections.sort(ar, new comparer());
        for(String s: ar)
            System.out.print(s+"");
    }
    // Made a repetition of the number and then compared it, whichever is the bigger, goes first
    private static String functionAnother(ArrayList<Integer> arr){
        int n = 
         Collections.max(arr).toString().length(); 
  
        ArrayList<ExtendedNum> en = 
                       new ArrayList<ExtendedNum>(); 
        for (int i = 0 ; i < arr.size(); i++) 
            en.add(new ExtendedNum(arr.get(i), 
                              n)); 
  
        // sort based on modified value 
        Collections.sort(en, (p1, p2) -> 
         (int)(p2.modifiedValue - p1.modifiedValue)); 
  
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < en.size(); i++) 
            sb.append(new StringBuilder 
            (Long.toString(en.get(i).originalValue))); 
  
  
        // To remove any zeroes at head. 
        BigInteger bi = new BigInteger(sb.toString()); 
  
        return bi.toString(); 
    }
    
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 34, 3, 98, 9, 76, 45, 4, 12, 121};
        function(arr);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i: arr)
            al.add(i);
        System.out.println();
        System.out.println(functionAnother(al));
    }
    
}

class ExtendedNum 
{ 
    int originalValue; 
    long modifiedValue; 
  
    public ExtendedNum(int originalValue, int n) 
    { 
        this.originalValue = originalValue; 
        String s = Integer.toString(originalValue); 
        StringBuilder sb = new StringBuilder(s); 
        StringBuilder ans = new StringBuilder(); 
        while (ans.length() <= n + 1) 
            ans.append(sb); 
  
        s = ans.toString().substring(0, n + 1); 
        modifiedValue = Long.parseLong(s); 
    } 
  
    public String toString() 
    { 
        return "[" + modifiedValue + 
                ", " + originalValue + "]"; 
    } 
} 
