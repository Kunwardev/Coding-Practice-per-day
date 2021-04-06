/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 *
 * @author kunwar
 */
public class WaysOfCoinChange {
    
    private static int function(int[] S, int m, int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0;i<m;i++){
            for(int j=S[i];j<=n;j++){
                dp[j] += dp[j-S[i]];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int[] S = new int[]{1,2,3};
        System.out.println(function(S, 3, 4));
    }
    
}
