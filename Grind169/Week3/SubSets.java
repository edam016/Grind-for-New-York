class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(nums, result, new ArrayList(), 0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> cand, int index){
        result.add(new ArrayList(cand));
        for(int i = index;i < nums.length; i++){
            cand.add(nums[i]);
            backtrack(nums, result, cand, i + 1);
            cand.remove(cand.size() - 1);
        }
    }
}