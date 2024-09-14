class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = 0;

        while(left < right){
            middle = (left + right)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(target > nums[middle]){
                left = middle + 1;
                
            }
            else{
                right = middle - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}