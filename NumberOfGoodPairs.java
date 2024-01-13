class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        int result = 0;
        for(int i = 0;i<=nums.length-1;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
                result += hm.get(nums[i]);
            }
            else{
                hm.put(nums[i], 0);
            }
        }
        return result;
    }
}