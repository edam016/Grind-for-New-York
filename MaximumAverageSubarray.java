class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int left = 0;
        int right = k;
        double average = 0;
        double maxAverage = 0;
        for(int i = 0;i<k;i++){
            sum += nums[i];
        }
        
        average = sum / k;
        maxAverage = average;

        while(right < nums.length){
            sum += nums[right];
            sum -= nums[left];

            right++;
            left++;

            average = sum / k;
            maxAverage = Math.max(average, maxAverage);
        }
        return maxAverage;
    }
}