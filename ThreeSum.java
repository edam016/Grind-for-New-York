class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList();
        HashSet<List<Integer>> hs = new HashSet();
        for(int i = 0;i<nums.length;i++){
            int left = i + 1;
            int right = nums.length-1;
            if(left == i){
                left++;
            }
            if(right == i){
                right--;
            }
            while(left < right){
                if((nums[i] + nums[left] + nums[right]) == 0){
                    List<Integer> found = new ArrayList();
                    found.add(nums[i]);
                    found.add(nums[left]);
                    found.add(nums[right]);
                    if(hs.add(found)){
                       arr.add(found); 
                    }
                    left++;
                }
                else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
                else{
                    left++;
                }
            }    
        }
        return arr;
    }
}