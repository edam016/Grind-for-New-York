class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList(), k, 1, n);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int index, int n){
        if(temp.size() == k){
            result.add(new ArrayList(temp));
            return;
        }
        for(int i = index;i<=n;i++){
            temp.add(i);
            backtrack(result, temp, k, i + 1, n);
            temp.remove(temp.size()-1);
        }
    }
}