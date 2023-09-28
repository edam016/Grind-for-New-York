class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        long sum = 0;
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet();
        List<List<Integer>> result = new ArrayList();
        for(int i = 0;i<=nums.length-4;i++){
            for(int j = i + 1;j<=nums.length-3;j++){
                int l = j + 1, r = nums.length-1;
                while(l < r){
                    sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        List<Integer> arr = new ArrayList();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[l]);
                        arr.add(nums[r]);
                        Collections.sort(arr);
                        if(hs.add(arr)){
                            result.add(arr);
                        }
                    }
                    if(sum > target){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
            }
        }
        return result;
    }
}