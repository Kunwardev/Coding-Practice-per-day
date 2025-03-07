package March;

public class LongestPalindromicSubsequence {
    
    private int longestPalinSubseqUtil(String s, String r){
        int length = s.length();
        int[][] dp = new int[length+1][length+1];
        for(int i=0;i<=length;i++){
            for(int j=0;j<=length;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else{
                    if(s.charAt(i-1)==r.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[length][length];
    }
    
    public int longestPalinSubseq(String s) {
        // code here
        String r = new StringBuilder(s).reverse().toString();
        return longestPalinSubseqUtil(s, r);
    }

}
