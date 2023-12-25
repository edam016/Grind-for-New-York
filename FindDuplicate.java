class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length-1;
        for(int num : nums){
            int idx = Math.abs(num);
            if(nums[idx] < 0){
                return idx;
            }
            nums[idx] = -nums[idx];
        }
        return len;
    }
    //using frequency array by marking integer array with negative value with nums[idx] = -nums[idx] and idx is the num from the array
}