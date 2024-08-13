class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length;
        for(int val : nums){
            if(val == 0){
                start++;
            }
            else if(val == 2){
                end--;
            }
        }
        for(int i = 0;i<start;i++){
            nums[i] = 0;
        }
        for(int i = end;i<nums.length;i++){
            nums[i] = 2;
        }
        for(int i = start;i<end;i++){
            nums[i] = 1;
        }
    }
}