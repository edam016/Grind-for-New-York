class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //count not off of sum but off of remainder
        HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0;
        int total = 0;
        hm.put(0, 1);

        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            int mod = sum % k;
            if(mod < 0){
                mod += k;
            } // way to make a negative value positive in Java
            if(hm.containsKey(mod)){
                total += hm.get(mod);
            }
            hm.put(mod, hm.getOrDefault(mod, 0) + 1);
        }
        return total;
    }
}