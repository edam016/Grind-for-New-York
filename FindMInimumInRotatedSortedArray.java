class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int middle = left + (right - left)/2;
            if(middle < nums.length - 1 && nums[middle] > nums[middle + 1]){
                return nums[middle + 1];
            }
            if(middle > 0 && nums[middle] < nums[middle - 1]){
                return nums[middle];
            }
            if(nums[middle] >= nums[left] && nums[middle] < nums[right] || nums[middle] < nums[left]){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return nums[left];
    }
}