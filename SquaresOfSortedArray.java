class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1;
        int [] arr = new int [nums.length];
        int i = nums.length-1;
        while(left <= right){
            if(nums[left]*nums[left] >= nums[right]*nums[right]){
                arr[i] = nums[left]*nums[left];
                left++;
            }
            else{
                arr[i] = nums[right]*nums[right];
                right--;
            }
            i--;
        }
        return arr;
    }
}