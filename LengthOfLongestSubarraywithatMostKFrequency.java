class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int maxVal = 0;
        int right = 0;
        int left = 0;
        int result = 1;
        boolean flag = false;
        while(right < nums.length){
            if(hm.containsKey(nums[right])){
                hm.put(nums[right], hm.get(nums[right]) + 1);
                if(hm.get(nums[right]) > k){
                    flag = true;
                }
            }
            else{
                hm.put(nums[right], 1);
            }
            while(flag && left <= right){
                if(hm.get(nums[left]) == k + 1){
                    flag = false;
                }
                hm.put(nums[left], hm.get(nums[left]) - 1);
                left++;
            }
            result = Math.max(right - left + 1, result);
            right++;
        }
        return result;
    }
}