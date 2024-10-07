class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int right = 0;
        int total = 0;
        int count = 0;
        hm.put(0, 1);
        while(right < nums.length){
            if(nums[right] % 2 != 0){
                count++;
            }
            if(hm.containsKey(count - k)){
                total += hm.get(count-k);
            }
            hm.put(count, hm.getOrDefault(count, 0) + 1);
            right++;
        }
        return total;
    }
}