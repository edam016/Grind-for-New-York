class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        while(right < nums.length){
            sum += nums[right];
            while(sum >= target && left <= right){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}