class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] fMap = new int[2];
        int right = 0;
        int left = 0;
        int maxLength = 0;
        int numZero = 0;
        while(right < nums.length){
            fMap[nums[right]]++;
            while(right - left + 1 -fMap[1]> k){
                fMap[nums[left]]--;
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        return maxLength;
    }
}