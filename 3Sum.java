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
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<List<Integer>, Integer> hm = new HashMap();
        List<List<Integer>> result = new ArrayList();
        for(int i = 0;i <= nums.length-1;i++){
            int l = i, r = nums.length-1;
            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum == 0 && l != i && i != r){
                    List<Integer> arr = new ArrayList();
                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    arr.add(nums[i]);
                    Collections.sort(arr);
                    if(!hm.containsKey(arr)){
                        result.add(arr);
                        hm.put(arr, 1);
                    }
                }
                if(sum > 0){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return result;
    }
}