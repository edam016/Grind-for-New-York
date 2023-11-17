class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1, middle = 0;
        while(left < right){
            middle = (left + right)/2;
            if(middle > 0 && middle < nums.length-1 && nums[middle] > nums[middle - 1] && nums[middle] > nums[middle+1]){
                return middle;
            }
            if(nums[middle + 1] >= nums[middle]){
                left = middle + 1;
            }
            else{
                right = middle;
            }
        }
        return left;
    }
}