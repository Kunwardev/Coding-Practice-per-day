package April;

import java.util.HashMap;
import java.util.HashSet;

public class findSubString {
    
    public int function(String s){
        HashSet<Character> charSet = new HashSet<>();
        for(char c: s.toCharArray()){
            charSet.add(c);
        }
        int requiredUniqueCount = charSet.size();
        int uniqueCountInWindow = 0, minLength = Integer.MAX_VALUE, left = 0, right = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(;right < s.length();right++){
            char rightChar = s.charAt(right);
            charMap.put(rightChar, charMap.getOrDefault(rightChar,0)+1);
            if(charMap.get(rightChar) == 1){
                uniqueCountInWindow++;
            }
            while(uniqueCountInWindow == requiredUniqueCount){
                minLength = Math.min(minLength, right - left + 1);
                char leftChar = s.charAt(left);
                charMap.put(leftChar, charMap.get(leftChar)-1);
                if(charMap.get(leftChar) == 0){
                    uniqueCountInWindow--;
                }
                left++;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        findSubString fs = new findSubString();
        // Example 1
        String str1 = "aabcbcdbca";
        System.out.println("Smallest window length: " + fs.function(str1)); // Output: 4

        // Example 2
        String str2 = "aaab";
        System.out.println("Smallest window length: " + fs.function(str2)); // Output: 2

        // Example 3
        String str3 = "abcd";
        System.out.println("Smallest window length: " + fs.function(str3)); // Output: 4

        // Example 4
        String str4 = "aaaa";
        System.out.println("Smallest window length: " + fs.function(str4)); // Output: 1
    }

}
