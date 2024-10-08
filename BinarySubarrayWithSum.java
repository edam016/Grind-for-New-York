class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int total = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, 1);
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(hm.containsKey(sum - goal)){
                total += hm.get(sum - goal);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public int atMost(int[] nums, int goal){
        int left = 0;
        int right = 0;
        int sum = 0;
        int total = 0;

        while(right < nums.length){
            sum += nums[right];
            while(sum > goal && left <= right){
                sum -= nums[left];
                left++;
            }
            right++;
            total += right - left + 1;
        }
        return total;
    }
}