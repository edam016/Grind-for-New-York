class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int right = 0;
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, -1); // used to calculate length. Use this for calculation
        while(right < nums.length){
            if(nums[right] == 1){
                sum++;
            }
            else{
                sum--;
            }

            if(hm.containsKey(sum)){
                maxLength = Math.max(maxLength, right - hm.get(sum));
            }
            else{
                hm.put(sum, right);
            }
            right++;
        }
        return maxLength;
    }
}