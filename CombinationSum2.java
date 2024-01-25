class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList(), candidates, target, 0, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int sum, int index){
        if(sum > target){
            return;
        }
        if(sum == target && !result.contains(temp)){
            result.add(new ArrayList(temp));
        }
        for(int i = index;i<candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            sum+= candidates[i];
            temp.add(candidates[i]);
            backtrack(result, temp, candidates, target, sum, i + 1);
            sum-=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}