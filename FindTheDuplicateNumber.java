class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        int middle = 0;

        while(left < right){
            middle = (left + right)/2;
            if(nums[middle] == nums[middle + 1]){
                return nums[middle];
            }
            if(nums[middle] <= middle){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return nums[left];
    }
}