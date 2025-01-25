/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 *
 * @author DEV
 */
public class MinNumberWhoseSumEqualsN {
    
    private static int getMinSquares(int n){
        if(n <= 3)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 3;
        for(int i=4;i<=n;i++){
            dp[i] = i;
            for(int j=1;j<=Math.ceil(Math.sqrt(i));j++){
                int temp = j*j;
                if(temp > i){
                    break;
                } else{
                    dp[i] = Math.min(dp[i], 1 + dp[i-temp]);
                }
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(getMinSquares(6));
    }
    
}
