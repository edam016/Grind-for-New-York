class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int val = 0;
        int elem = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(elem == nums[i]){
                count++;
            }
            else{
                if(count > nums.length/2){
                    return elem;
                }
                count = 1;
                elem = nums[i];
            }
        }
        return elem;
    }
}