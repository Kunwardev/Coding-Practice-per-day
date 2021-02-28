/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.String;

import java.util.Arrays;

/**
 *
 * @author kunwar
 */
public class LongestSubstringWithKChars {
    
    private static final int MAX_CHAR = 26;
    
    private static void function(String s, int k){
        int distinctChars = 0;
        int length = s.length();
        
        int[] count = new int[MAX_CHAR];
        
        for(int i=0;i<length;i++){
            if(count[s.charAt(i) - 'a'] == 0)
                distinctChars++;
            count[s.charAt(i)-'a']++;
        }
        
        if(distinctChars < k){
            System.out.println("The Distinct Characters are less than required");
            return;
        }
        
        int currStart = 0, currEnd = 0, maxWindowSize = 1, maxWindowStart = 0;
        Arrays.fill(count, 0);
        
        count[s.charAt(0)-'a']++;
        
        for(int i=1; i<length; i++){
            count[s.charAt(i) - 'a']++;
            currEnd++;
            
            while(!isValid(count, k)){
                count[s.charAt(currStart) - 'a']--;
                currStart++;
            }
            
            if(maxWindowSize < (currEnd-currStart+1)){
                maxWindowStart = currStart;
                maxWindowSize = (currEnd-currStart+1);
            }
            
        }
        
        System.out.println("Maximum SubString with Distinct Characters: "+
                s.substring(maxWindowStart, maxWindowStart+maxWindowSize));
        
    }

    private static boolean isValid(int[] count, int k) {
        int val = 0;
        for(int i=0;i<MAX_CHAR;i++){
            if(count[i] > 0)
                val++;
        }
        return k >= val;
    }
    
    
    public static void main(String[] args) {
        String s = "aabacbebebe";  
        int k = 1;
        function(s, k);
    }
    
}
