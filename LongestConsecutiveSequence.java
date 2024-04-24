class Solution {
    public int longestConsecutive(int[] nums) {
        int maxResult = 0;
        HashSet<Integer> hs = new HashSet();
        for(int i = 0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        for(int val : nums){
            int left = val - 1;
            int right = val + 1;
            while(hs.contains(left)){
                hs.remove(left);
                left--;
            }
            while(hs.contains(right)){
                hs.remove(right); 
                right++;
            }
            maxResult = Math.max(maxResult, right - left - 1);
        }
        return maxResult;
    }
}