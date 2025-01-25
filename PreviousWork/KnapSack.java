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
public class KnapSack {
    
    private static int function(int[] wt, int[] val, int W, int n){
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0 || w==0){
                    dp[i][w] = 0;
                } else if(wt[i-1] <= w){
                    dp[i][w] = Math.max(dp[i-1][w], val[i-1]+dp[i-1][w-wt[i-1]]);
                } else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][W];
    }
    
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(function(wt, val, W, n));
    }
    
}
