class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = 0;

        while(left < right){
            middle = left + (right - left)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[middle] >= nums[left]){
                //left side
                if(target > nums[middle] || target < nums[left]){
                    left = middle + 1;
                }
                else{
                    right = middle - 1;
                }
            }
            else{
                //right side
                if(target < nums[middle] || target > nums[right]){
                    right = middle - 1;
                }
                else{
                    left = middle + 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}