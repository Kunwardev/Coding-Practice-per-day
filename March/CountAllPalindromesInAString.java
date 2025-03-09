package March;

public class CountAllPalindromesInAString {
    
    // Another way is to use DP, just like for Longest Palindrome SubSequence

    // Using Recursion
    private int countPalindromeFromCenter(String s, int left, int right){
        int count = 0;
        int length = s.length();
        while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){
            if(right-left+1 >= 2){
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
    
    public int countPS(String s) {
        // code here
        int length = s.length();
        int totalCount = 0;
        for(int i=0;i<length;i++){
            totalCount += countPalindromeFromCenter(s, i, i);
            totalCount += countPalindromeFromCenter(s, i, i+1);
        }
        return totalCount;

}
