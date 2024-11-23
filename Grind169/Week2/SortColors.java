class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                zero++;
            }
            else if(nums[i] == 2){
                two--;
            }
        }

        for(int i = 0;i<zero;i++){
            nums[i] = 0;
        }
        for(int i = two;i< nums.length;i++){
            nums[i] = 2;
        }
        for(int i = zero;i<two;i++){
            nums[i] = 1;
        }
    }
}