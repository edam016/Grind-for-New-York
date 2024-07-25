class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        int longest = 0;
        for(int i = 0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        for(int val : nums){
            int left = val-1, right = val+1;
            while(hs.contains(left)){
                hs.remove(left);
                left--;
            }
            while(hs.contains(right)){
                hs.remove(right);
                right++;
            }
            longest = Math.max(longest, right - left - 1);
        }
        return longest;
    }
}