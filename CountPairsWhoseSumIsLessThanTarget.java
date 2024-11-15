class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        for(int i = 0;i<nums.size();i++){
            int left = i + 1;
            int right = nums.size() - 1;

            while(left <= right){
                int middle = (left + right) /2;
                if(nums.get(middle) + nums.get(i) < target){
                    left = middle + 1;
                }
                else{
                    right = middle - 1;
                }
            }
            count += left - i - 1;

            //minus 1 as left. > right in this case and it is 1 greater then the largest value in nums. Binary search converged left/right to where
            //the highest index which is less than target
        }
        return count;
    }
}