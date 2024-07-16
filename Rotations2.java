class Solution {
    public void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        swap(nums, 0, nums.length-1);
        swap(nums, 0, rotations - 1);
        swap(nums, rotations, nums.length-1);
    }

    public void swap(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}