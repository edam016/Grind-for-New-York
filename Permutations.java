class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arr = new ArrayList();
        backtrack(arr, new ArrayList(), nums);
        return arr;
    }

    public void backtrack(List<List<Integer>> arr, List<Integer> temp, int[] nums){
        
        if(temp.size() == nums.length){
            arr.add(new ArrayList(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            backtrack(arr, temp, nums);
            temp.remove(temp.size()-1);
        }class Solution {
            public List<List<Integer>> combine(int n, int k) {
                List<List<Integer>> res = new ArrayList();
                backtrack(res, new ArrayList(), n, k, 1);
                return res;
            }
        
            public void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int index){
                if(temp.size() == k){
                    res.add(new ArrayList(temp));
                    return;
                }
                for(int i = index;i<=n;i++){
                    temp.add(i);
                    backtrack(res, temp, n, k, i + 1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}