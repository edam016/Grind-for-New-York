class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, int[] nums, List<Integer> candidate, int index){
        result.add(new ArrayList<>(candidate));
        for(int i = index;i<nums.length;i++){
            candidate.add(nums[i]);
            backtrack(result, nums, candidate, i + 1);
            candidate.remove(candidate.size()-1);
        }
    }
}