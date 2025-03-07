package March;

public class LongestPalindromicSubSeq {
    
    private static String longestPalindrome(String s) {
        // code here
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int start = 0, maxLength = 1;
        for(int i=0;i<length;i++){
            dp[i][i] = true;
        }
        for(int i=0;i<length-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                if(maxLength < 2){
                    maxLength = 2;
                    start = i;
                }
            }
        }
        
        for(int k=3;k<=length;k++){
            for(int i=0;i<length-k+1;i++){
                int j=i+k-1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if(maxLength < k){
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLength);
    }


}
