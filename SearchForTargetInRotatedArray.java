class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int middle = (start +end)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[start] == target){
                return start;
            }
            if(nums[end] == target){
                return end;
            }
            if(target > nums[middle] && target > nums[end] && target > nums[start] && nums[middle] > nums[start] || target > nums[middle] && target > nums[start] && target < nums[end] || target < nums[middle] && target < nums[start] && target < nums[end] && nums[middle] > nums[end] || target > nums[middle] && target < nums[start] && target < nums[end]){
                start = middle + 1;
                System.out.println("trigger 1");
            }
            else{
                end = middle - 1;
                 System.out.println("trigger 2");
            }
        }
        return nums[start] == target ? start : -1;
    }
}

//not efficient, redo question