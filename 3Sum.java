class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        for(int i =0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start < end){
                int total = nums[i] + nums[start] + nums[end];
                if(total == 0){
                    res.add(Arrays.asList(nums[i], nums[start++], nums[end]));
                }
                else if(total > 0){
                    end--;
                }
                else if(total < 0){
                    start++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}