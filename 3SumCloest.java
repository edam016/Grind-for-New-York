class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            int left = i + 1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(Math.abs(sum - target) < diff){
                    diff = Math.abs(sum - target);
                    closest = sum;
                }
                if(sum > target){
                    right--;
                }
                else{
                    left++;
                }
            }

        }
        return closest;
    }
}