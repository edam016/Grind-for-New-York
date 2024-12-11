class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0;
        int maxLength = 0;
        hm.put(0, -1);
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(hm.containsKey(sum - k)){
                maxLength = Math.max(maxLength, i - hm.get(sum - k));
            }
            if(hm.containsKey(sum)){
                continue;
            }
            else{
                hm.put(sum, i);
            }
        }
        return maxLength;
    }
}