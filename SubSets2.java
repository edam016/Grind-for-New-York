class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        backtrack(result, new ArrayList(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int index){
        if(!result.contains(temp)){
            result.add(new ArrayList(temp));
        }
        for(int i = index;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size()-1);
        }
    }
}