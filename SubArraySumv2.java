class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int total = 0;
        int sum = 0;
        hm.put(0, 1);
        
        for(int val : nums){
            sum += val;
            if(hm.containsKey(sum - k)){
                total += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}