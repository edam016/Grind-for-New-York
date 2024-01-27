class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        //have one robber go from 0, n-1 and 1, n
        return Math.max(solve(nums, 0, nums.length-2), solve(nums, 1, nums.length-1));
    }

    public int solve(int[] nums, int start, int end){
        int first = nums[start];
        int second = Math.max(nums[start + 1], nums[start]);
        for(int i = start+2;i<=end;i++){
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }
        return second;
    }
}