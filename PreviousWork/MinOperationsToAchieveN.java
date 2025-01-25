/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 *
 * @author kunwar
 */
public class MinOperationsToAchieveN {
    
    private static int functionDP(int N){
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        for(int index=2; index<=N; index++){
            if(index % 2 == 0){
                int x = dp[index / 2];
                dp[index] = Math.min(x+1, dp[index]);
            }
            if(index % 3 == 0){
                int x = dp[index / 3];
                dp[index] = Math.min(x+1, dp[index]);
            }
            int x = dp[index-1];
            dp[index] = Math.min(x+1, dp[index]);
        }
        return dp[N];
    }
    
    public static void main(String[] args) {
        int N = 7;
        System.out.println(functionDP(N));
    }
    
}
