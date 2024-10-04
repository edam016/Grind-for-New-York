class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxVal = 0;
        int right = 0;
        int left = 0;
        long total = 0;
        long count = 0;

        for(long val : nums){
            maxVal = Math.max(val, maxVal);
        }

        while(right < nums.length){
            if(nums[right] == maxVal){
                count++;
            }
            while(count >= k){
                if(nums[left] == maxVal){
                    count--;
                }
                total += nums.length - right;
                left++;

                //logic is that the current array has conditions met so future arrays until the end of the array
                //from nums.length to right will be an array that satisfies the condition
            
            }
            right++;
        }
        return total;
    }
}