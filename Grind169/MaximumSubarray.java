class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(right < nums.length){
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
            if(sum <= 0){
                sum = 0;
            }
            right++;
        }
        return maxSum;
    }
}