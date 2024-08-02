class Solution {
    public List<List<Integer>> threeSum(int[] nums){
            List<List<Integer>> result = new ArrayList();
            Arrays.sort(nums);
            HashSet<List<Integer>> hs = new HashSet();
            for(int i = 0;i<nums.length;i++){
                int left = i+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[left] + nums[right] + nums[i];
                    if(sum == 0 ){
                        List<Integer> arr = new ArrayList();
                        arr.add(nums[left]);
                        arr.add(nums[right]);
                        arr.add(nums[i]);
                        Collections.sort(arr);
                        hs.add(arr);
                        right--;
                    }
                    else if(sum > 0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
            for(List<Integer> val : hs){
                result.add(val);
            }
            return result;
        }
}