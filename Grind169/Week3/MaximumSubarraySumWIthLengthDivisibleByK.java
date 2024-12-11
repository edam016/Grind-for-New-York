class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] prefixSums = new long[nums.length + 1];

        for(int i = 1;i<=nums.length;i++){
            prefixSums[i] = nums[i - 1] + prefixSums[i - 1];
        }

        long maxVal = Long.MIN_VALUE;

        for(int i = 0;i < k;i++){
            int current = i;
            long carry = 0;
            while(current + k <= nums.length){
                long add = prefixSums[current + k] - prefixSums[current];
                if(carry < 0){
                    carry = 0;
                }
                carry += add;
                maxVal = Math.max(maxVal, carry);
                current += k;
            }
        }
        return maxVal;
    }
}