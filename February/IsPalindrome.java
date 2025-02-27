package February;

public class IsPalindrome {
    // 2 pointer approach
    boolean isPalindrome(String s) {
        // code here
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
