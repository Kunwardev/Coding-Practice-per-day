package March;

import java.util.Arrays;

public class CountWaysofSumCoins{
    public int countDp(int[] coins, int sum, int length, int[][] dp){
        if(sum == 0)
            return 1;
        if(sum < 0 || length == 0){
            return 0;
        }
        if(dp[length-1][sum] != -1)
            return dp[length-1][sum];
        return dp[length-1][sum] = countDp(coins, sum, length-1, dp) + 
                                    countDp(coins, sum-coins[length-1],length, dp);
    }
    
    public int count(int coins[], int sum) {
        // code here.
        int[][] dp = new int[coins.length][sum+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return countDp(coins, sum, coins.length, dp);
    }

    public static void main(String[] args) {
        CountWaysofSumCoins c = new CountWaysofSumCoins();
        int[] coins1 = {1, 2, 3};
        int sum1 = 4;
        int[] coins2 = {2, 5, 3, 6};
        int sum2 = 10;
        System.out.println(c.count(coins2, sum2));
        System.out.println(c.count(coins1, sum1));
    }
}