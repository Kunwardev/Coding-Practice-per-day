package March;

import java.util.HashSet;

public class KLengthSubstringWithNorepetition{
    public int numKLenSubstrNoRepeats(String s, int k) {
        int ans = 0;
        int length = s.length();
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        for(;right<length;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            if(right - left + 1 == k){
                ans++;
                set.remove(s.charAt(left++));
            }
        }
        return ans;
    }
}