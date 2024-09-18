class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int middle = left + (right - left)/2;
            if(nums[middle]>nums[middle + 1]){
                return nums[middle + 1];
            }

            if(nums[left] > nums[middle] || nums[right] > nums[left]){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return nums[left];
    }
}