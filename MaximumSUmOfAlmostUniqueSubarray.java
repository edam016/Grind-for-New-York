class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        long sum = 0;
        long maxSum = 0;

        while(right < nums.size()){
            sum += nums.get(right);
            hm.put(nums.get(right), hm.getOrDefault(nums.get(right), 0) + 1);
            while(right - left + 1 > k && left <= right){
                sum -= nums.get(left);
                if(hm.get(nums.get(left)) == 1){
                    hm.remove(nums.get(left));
                }
                else{
                    hm.put(nums.get(left), hm.get(nums.get(left)) - 1);
                }
                left++;
            }
            if(hm.size() >= m){
                maxSum = Math.max(sum, maxSum);
            }
            right++;
        }
        return maxSum;
    }
}