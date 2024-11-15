class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for(int i = 0;i<nums.length;i++){
            int left = i + 1;
            int right = nums.length - 1;
            int resultLow = 0;
            int resultHigh = 0;
            while(left <= right){
                int middle = (left + right) / 2;
                if(nums[middle] >= lower - nums[i]){
                    right = middle - 1;
                }
                else{
                    left = middle + 1;
                }
            }
            resultLow = right;
            left = i + 1;
            right = nums.length - 1;

            while(left <= right){
                int middle = (left + right) / 2;
                if(nums[middle] <= upper - nums[i]){
                    left = middle + 1;
                }
                else{
                    right = middle - 1;
                }
            }
            resultHigh = right;
            if(resultHigh >= resultLow && resultHigh >= i + 1){
                count += resultHigh - resultLow ;
            }
        }
        return count;
    }


}