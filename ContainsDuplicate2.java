class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int minimum = Integer.MAX_VALUE;
        for(int i = 0;i<=nums.length-1;i++){
            if(hm.containsKey(nums[i])){
                minimum = Math.min(Math.abs(hm.get(nums[i]) - i), minimum);
                hm.put(nums[i], i);
            }
            else{
                hm.put(nums[i], i);
            }
        }
        return minimum <= k;
    }
}