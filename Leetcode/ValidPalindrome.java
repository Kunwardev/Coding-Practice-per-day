package Leetcode;

public class ValidPalindrome {
    
    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }

    public boolean validPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(right) != s.charAt(left)){
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String test1 = "abca";
        boolean result1 = vp.validPalindrome(test1);
        System.out.println("Test case 1: " + result1); // Expected: true

        // Test case 2: Palindrome without any removal
        String test2 = "racecar";
        boolean result2 = vp.validPalindrome(test2);
        System.out.println("Test case 2: " + result2); // Expected: true
    }

}
