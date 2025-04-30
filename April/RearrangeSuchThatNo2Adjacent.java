package April;

import java.util.HashMap;

public class RearrangeSuchThatNo2Adjacent {
    
    private String function(String s){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxCount = 0; char maxCh='0';
        for(int i=0;i<s.length();i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
            if(freqMap.get(s.charAt(i)) > maxCount){
                maxCount = freqMap.get(s.charAt(i));
                maxCh = s.charAt(i);
            }
        }
        if(maxCount > s.length()/2){
            return "";
        }
        char[] res = new char[s.length()];
        int index = 0;
        while(maxCount > 0){
            res[index] = maxCh;
            index+=2;
            maxCount--;
            freqMap.put(maxCh, freqMap.getOrDefault(maxCh, 0)-1);
        }
        for(char c = 'a'; c <= 'z'; c++){
            while(freqMap.getOrDefault(c, 0) > 0){
                index = index >= s.length() ? 1 : index;
                res[index] = c;
                index+=2;
                freqMap.put(c, freqMap.get(c)-1);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        RearrangeSuchThatNo2Adjacent rearranger = new RearrangeSuchThatNo2Adjacent();

        // Test case 1: Valid input with no two adjacent characters
        String input1 = "aabb";
        String expectedOutput1 = "abab"; // or "baba"
        String actualOutput1 = rearranger.function(input1);
        System.out.println("Test case 1: " + (!actualOutput1.isEmpty() && isValidOutput(input1, actualOutput1) ? "Passed" : "Failed"));

        // Test case 2: Invalid input where rearrangement is not possible
        String input2 = "aaab";
        String expectedOutput2 = ""; // Not possible to rearrange
        String actualOutput2 = rearranger.function(input2);
        System.out.println("Test case 2: " + (expectedOutput2.equals(actualOutput2) ? "Passed" : "Failed"));
    }

    private static boolean isValidOutput(String input, String output) {
        // Helper function to check if no two adjacent characters are the same
        for (int i = 1; i < output.length(); i++) {
            if (output.charAt(i) == output.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
