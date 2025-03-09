package March;

public class EditDistance {
    
    private int editDistance(String s1, String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1+1][length2+1];
        for(int i=0;i<=length1;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=length2;i++){
            dp[0][i] = i;
        }
        
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }

    // Took the help of CoPilot to create some test cases
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();

        // Test case 1: Both strings are empty
        System.out.println(editDistance.editDistance("", "") == 0 ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: One string is empty
        System.out.println(editDistance.editDistance("abc", "") == 3 ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3: Both strings are the same
        System.out.println(editDistance.editDistance("abc", "abc") == 0 ? "Test case 3 passed" : "Test case 3 failed");

        // Test case 4: Strings with one character difference
        System.out.println(editDistance.editDistance("abc", "abx") == 1 ? "Test case 4 passed" : "Test case 4 failed");

        // Test case 5: Strings with multiple differences
        System.out.println(editDistance.editDistance("kitten", "sitting") == 3 ? "Test case 5 passed" : "Test case 5 failed");

        // Test case 6: Strings with different lengths
        System.out.println(editDistance.editDistance("flaw", "lawn") == 2 ? "Test case 6 passed" : "Test case 6 failed");
    }

}

