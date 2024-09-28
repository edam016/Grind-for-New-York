class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        //cycle detection algorithm
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int middle = left + (right - left)/2;
            if(nums[middle] == nums[middle + 1]){
                return nums[middle];
            }
            if(nums[middle] <= middle){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return nums[left];
    }
}