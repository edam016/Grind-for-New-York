class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        int maxLength = 0;
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0;i<nums.length;i++){
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            while(hm.containsKey(left)){
                hm.remove(left);
                left--;
            }
            while(hm.containsKey(right)){
                hm.remove(right);
                right++;
            }
            maxLength = Math.max(right - left - 1, maxLength);
        }
        return maxLength;
    }
}