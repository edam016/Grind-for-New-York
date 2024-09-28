class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1){
            return;
        }
        int rotations = k%nums.length;
        if(rotations == 0){
            return;
        }
        flip(nums, 0, nums.length-1);
        flip(nums, 0, rotations-1);
        flip(nums, rotations, nums.length-1);

    }

    public void flip(int[] nums, int start, int end){
        int left = start;
        int right = end;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}