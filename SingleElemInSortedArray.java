class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1, middle = 0;
        while(left < right){
            middle = (left + right)/2;
            if(middle % 2 == 1){
                middle--;
            }
            if(nums[middle] != nums[middle+1]){
                right = middle;
            }
            else{
                left = middle + 2;
            }
        }
        return nums[left];
    }
}