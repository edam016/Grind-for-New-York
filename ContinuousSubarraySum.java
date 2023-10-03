class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int total = 0;
        hm.put(0, -1);
        for(int i = 0;i<=nums.length-1;i++){
            total += nums[i];
            if(hm.containsKey(total%k)){
                if(i - hm.get(total%k) > 1){
                    return true;
                }
            }
            else{
                hm.put(total%k, i);
            }
        }
        return false;
    }
}