class Solution {
    public int longestArithSeqLength(int[] nums) {
        if(nums.length < 2){
            return 1;
        }
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];

        int longestLength = 2;
        int diff, freqAtVal;
        for(int i  = 0;i<nums.length;i++){
            dp[i] = new HashMap();
        }
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j < i;j++){
                diff = nums[i] - nums[j];
                freqAtVal = dp[j].getOrDefault(diff, 1);
                longestLength = Math.max(freqAtVal + 1, longestLength);
                dp[i].put(diff, freqAtVal + 1);
            }
        }
        return longestLength;
    }
}