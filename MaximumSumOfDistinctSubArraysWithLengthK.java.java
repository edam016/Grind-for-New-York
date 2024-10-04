class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int total = 0;
        long sum = 0;
        long maxSum = 0;
        HashSet<Integer> hs = new HashSet();
        while(right < nums.length){
            sum += nums[right];
            while(!hs.add(nums[right])){
                sum -= nums[left];
                hs.remove(nums[left]);
                left++;
            }
            while(right - left + 1 >= k && hs.size() >= k){
                maxSum = Math.max(sum, maxSum);
                sum -= nums[left];
                hs.remove(nums[left]);
                left++;
            }
            right++;
        }
        return maxSum;
    }
}