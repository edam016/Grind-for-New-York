class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        //cycle detection algorithm
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int middle = left + (right - left)/2;
            if(nums[middle] == nums[middle + 1]){
                return nums[middle];
            }
            if(nums[middle] <= middle){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return nums[left];
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(slow != fast);

        slow = 0;

        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}