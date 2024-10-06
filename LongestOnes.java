class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int count = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                count++;
            }
            while(count > k && left <= right){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        return maxLength;
    }
}