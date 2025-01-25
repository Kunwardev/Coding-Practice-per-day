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
public class LongestCommonSubsequence {
    
    private static int lcs(char[] x, char[] y, int m, int n){
        int[][] L = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i== 0 || j==0){
                    L[i][j] = 0;
                } else if(x[i-1] == y[j-1]){
                    L[i][j] = 1 + L[i-1][j-1];
                } else{
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
                }
            }
        }
        return L[m][n];
    }
    
    public static void main(String[] args) {
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB"; 

        char[] X=s1.toCharArray(); 
        char[] Y=s2.toCharArray(); 
        int m = X.length; 
        int n = Y.length; 
        System.out.println(lcs(X, Y, m, n));
    }
    
}
