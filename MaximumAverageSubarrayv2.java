class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k;
        double sum = 0;
        for(int i = 0;i<k;i++){
            sum += nums[i];
        }
        double maxAv = sum/k;
        while(right < nums.length){
            sum += nums[right];
            sum -= nums[left];
            left++;
            right++;
            maxAv = Math.max(sum/k, maxAv);
        }
        return maxAv;
    }
}