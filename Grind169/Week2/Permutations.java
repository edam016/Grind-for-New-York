class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList(), nums);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> cand, int[] nums){
        if(cand.size() == nums.length){
            result.add(new ArrayList(cand));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!cand.contains(nums[i])){
                cand.add(nums[i]);  
                backtrack(result, cand, nums);
                cand.remove(cand.size()-1);
            }
        }
    }
}