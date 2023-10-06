class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, maxLength = Integer.MAX_VALUE, start = 0;
        for(int i = 0;i<=nums.length-1;i++){
            sum += nums[i];
            while(sum >= target){
                maxLength = Math.min(maxLength, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return maxLength == Integer.MAX_VALUE ? 0 : maxLength;
    }
}