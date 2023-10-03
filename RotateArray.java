class Solution {
    public void rotate(int[] nums, int k) {
        int rotation = k % nums.length;
        swap(nums, 0, nums.length-1);
        swap(nums, 0, rotation - 1);
        swap(nums, rotation , nums.length-1);
    }

    public void swap(int[]nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}