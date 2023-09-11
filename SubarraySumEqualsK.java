public class SubarraySumEqualsK {
    
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        int total = 0;
        preSum.put(0, 1);
        for(int i = 0;i<=nums.length-1;i++){
            total += nums[i];
            if(preSum.containsKey(total - k)){
                result += preSum.get(total - k);
            }
            if(preSum.containsKey(total)){
                preSum.put(total, preSum.get(total) + 1);
            }
            else{
                preSum.put(total, 1);
            }
        }
        return result;
    }
}