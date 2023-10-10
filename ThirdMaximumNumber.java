class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int maxVal = 0;
        int result = 0;
        HashSet<Integer> hs = new HashSet();
        for(int i = nums.length-1;i>=0;i--){
            if(hs.add(nums[i])){
                index++;
                result = nums[i];
            }
            if(index == 3){
                return result;
            }
            maxVal = Math.max(nums[i], maxVal);
        }
        return maxVal;
    }
}