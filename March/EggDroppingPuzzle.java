package March;

public class EggDroppingPuzzle {
    

    // n -> No of eggs, k -> no of floors
    private int eggDropRecur(int n, int k){
        if(n == 1)
            return k;
        if(k == 0 || k == 1)
            return k;
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
                            // Egg Broke, so gng one floor down, Egg did not break, so, considering other floors
            int breakf = 1 + Math.max(eggDropRecur(n-1, i-1), eggDropRecur(n, k-i));
            res = Math.min(res, breakf);
        }
        return res;
    }

    private int eggDropDp(int n, int k){
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for (int j = 1; j <= k; j++)
            dp[1][j] = j;
        
        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                int res = Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                    res = Math.min(res, 1+Math.max(dp[i-1][x-1], dp[i][j-x]));
                }
                dp[i][j] = res;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        EggDroppingPuzzle e = new EggDroppingPuzzle();
        System.out.println(e.eggDropDp(2, 10));
    }
}
