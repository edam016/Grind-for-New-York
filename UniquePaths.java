class Solution {
    public int uniquePaths(int m, int n) {
        /**
        
        This seems to be a dp as it is return the maximum number of paths

        Function: f(x,y) = f(x - 1)(y) + f(x)(y - 1)
        Add up all number of ways to arrive to previous squares
         */
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i > 0 && j > 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                else if(i > 0){
                    dp[i][j] = dp[i - 1][j];
                }
                else if(j > 0){
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}