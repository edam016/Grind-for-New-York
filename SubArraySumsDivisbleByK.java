class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0;
        int total = 0;
        hm.put(0, 1);
        for(int val : nums){
            sum += val;
            int mod = sum % k;
            if(mod < 0){
                mod += k;
            }
            if(hm.containsKey(mod)){
                total += hm.get(mod);
            }
            hm.put(mod, hm.getOrDefault(mod, 0) + 1);
        }
        return total;
    }
}