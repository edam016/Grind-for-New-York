class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0; //Make sure to use long to ensure no memory loss on the variable
        long result = 0;
        for(int i = 0;i<=nums.length-1;i++){
            if(nums[i] == 0){
                count++;
                result+=count;
            }
            else{
                count = 0;
            }
        }
        return result;
    }
}