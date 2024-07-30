class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1;
        int[] result = new int[nums.length];
        int j = nums.length-1;
        while(left <= right){
            if(Math.pow(nums[left], 2) > Math.pow(nums[right], 2)){
                result[j] = (int)Math.pow(nums[left], 2);
                left++;
            }
            else{
                result[j] = (int)Math.pow(nums[right], 2);
                right--;
            }
            j--;
        }
        return result;
    }
}