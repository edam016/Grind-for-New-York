class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        int maxLength = 0;
        for(int val : nums){
            hs.add(val);
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
            maxLength = Math.max(right - left - 1, maxLength);
        }
        return maxLength;
    }
}