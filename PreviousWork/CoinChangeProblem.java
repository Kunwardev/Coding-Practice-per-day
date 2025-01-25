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
public class CoinChangeProblem {
    
    private static int function(int[] coins, int sum){
        int[] ways = new int[sum+1];
        ways[0] = 1; 
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<ways.length;j++){
                if(coins[i] <= j){
                    ways[j] += ways[j-coins[i]];
                }
            }
        }
        return ways[sum];
    }
    
    public static void main(String[] args) {
        int[] coins = new int[]{1,5,10};
        System.out.println(function(coins, 10));
    }
    
}
