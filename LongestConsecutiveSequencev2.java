class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int max = 0;
        for(int i = 0;i<=nums.length-1;i++){
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
            int sequence = right - left - 1;
            max = Math.max(sequence, max);
        }
        return max;
    }
}