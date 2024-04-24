class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                start++;
            }
            else if(nums[i] == 2){
                end--;
            }
        }
        for(int i = 0;i<start;i++){
            nums[i] = 0;
        }
        for(int i = start;i<end;i++){
            nums[i] = 1;
        }
        for(int i = end;i<nums.length;i++){
            nums[i] = 2;
        }
    }
}