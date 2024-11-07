class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int middle = left + (right - left)/2;
            if(target > nums[middle]){
                left = middle + 1;
            }
            else{
                right= middle;
            }
        }
        return nums[left] == target ? left : -1;
    }
}