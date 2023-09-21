class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length*2];
        int j = nums.length;
        for(int i = 0;i<nums.length;i++){
            result[i] = nums[i];
            result[j] = nums[i];
            j++;
        }
        return result;
    }
}