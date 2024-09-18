class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int middle = 0;

        if(nums.length == 1){
            return 0;
        }

        while(left < right){
            middle = left + (right - left)/2;
            if(nums[middle] > nums[middle + 1]){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return left;
    }
}
