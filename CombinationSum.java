class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList(), candidates, 0, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> arr, int[] candidates, int sum, int target, int index){
        if(sum == target){
            result.add(new ArrayList(arr));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = index;i<candidates.length;i++){
            sum += candidates[i];
            arr.add(candidates[i]);
            backtrack(result, arr, candidates, sum, target, i);
            sum -= candidates[i];
            arr.remove(arr.size()-1);
        }
    }
}