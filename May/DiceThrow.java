package May;

import java.util.Arrays;

public class DiceThrow {
    
    // M Face of a Dice
    // N Dices
    // X Target to make with N dices with M faces

    private static int noOfWays(int m, int n, int x){
        int[][] dp = new int[n+1][x+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return noOfWaysUtil(m, n, x, dp);
    }

    private static int noOfWaysUtil(int m, int n, int x, int[][] dp) {
        if(n == 0 && x == 0)
            return 1;
        if(n == 0 || x <= 0)
            return 0;
        if(dp[n][x] != -1)
            return dp[n][x];
        int ans = 0;
        for(int i=1;i<=m;i++){
            ans += noOfWaysUtil(m, n-1, x-i, dp);
        }
        return dp[n][x] = ans;
    }

}
