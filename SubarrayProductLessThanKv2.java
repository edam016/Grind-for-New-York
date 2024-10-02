class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap();
        int prod = 1;
        int right = 0;
        int total = 0;
        int left = 0;

        while(right < nums.length){
            prod *= nums[right];
            while(prod >= k && left <right){
                prod /= nums[left];
                left++;
            }
            total += right - left + 1;
            right++;
        }
        return total;
    }
}