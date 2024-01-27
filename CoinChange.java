class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int coin : coins){
                if(i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
                    //subtracting a coin from target at dp[i] and seeing what coins are needed to make up the rest of it
                    //for example if 11 then we try the coins 1,2,5. If we try 1 then we see what the optimal amount for 10 was. If 2, we check for 9 and for 5 we check 6. 
                    //Example at dp[6], we check dp[6-coin] so 1,2,5 were subtracted from 6.
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}