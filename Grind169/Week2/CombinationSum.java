class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList(), candidates, 0, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> arr, int[] candidates, int sum, int target, int start){
        if(sum == target){
            result.add(new ArrayList(arr));
        }
        else if(sum > target){
            return;
        }
        for(int i = start;i<candidates.length;i++){
            sum += candidates[i];
            arr.add(candidates[i]);
            backtrack(result, arr, candidates, sum, target, i);
            sum -= candidates[i];
            arr.remove(arr.size() - 1);
        }
    }
}