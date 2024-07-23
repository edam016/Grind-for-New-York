class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dupes = new ArrayList();
        int idx = 0;
        for(int i = 0;i<nums.length;i++){
            idx = Math.abs(nums[i])-1;
            if(nums[idx] >= 0){
                nums[idx] = -nums[idx];
            }
            else{
                dupes.add(idx+1);
            }
        }
        return dupes;
    }
}