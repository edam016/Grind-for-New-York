class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int sumL = 0, sumR = 0,index = 0;
        for(int i = 0;i<=nums.length-1;i++){
            sumR += nums[i];
        }
        for(int i = 0;i<=nums.length-1;i++){
            if(sumL == sumR-nums[i]){
                return i;
            }
            sumL += nums[i];
            sumR -= nums[i];
        }
        return -1;
    }
}