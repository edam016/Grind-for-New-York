class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxCount = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                maxCount = 1;
                for(int j = i - 1;j>=0;j--){
                    if(nums[j] < nums[i]){
                        maxCount = Math.max(dp[j] + 1, maxCount);
                    }
                }
                dp[i] = maxCount;
            }
            else{
                maxCount = 1;
                for(int j = i - 1;j>=0;j--){
                    if(nums[j] < nums[i]){
                        maxCount = Math.max(dp[j] + 1, maxCount);
                    }
                }
                dp[i] = maxCount;
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for(int val : dp){
            maxVal = Math.max(val, maxVal);
        }
        return maxVal;
    }
}