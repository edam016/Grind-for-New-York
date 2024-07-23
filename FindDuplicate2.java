class Solution {
    public int findDuplicate(int[] nums) {
        int idx = 0;
        for(int i = 0 ;i<nums.length;i++){
            idx = Math.abs(nums[i]) - 1;
            if(nums[idx] >= 0){
                nums[idx] = -nums[idx];
            }
            else{
                return idx+1;
            }
        }
        return idx;
    }
}