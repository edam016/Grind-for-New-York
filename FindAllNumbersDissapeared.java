class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        List<Integer> arr = new ArrayList();
        for(int i = 0;i<=nums.length-1;i++){
            hs.add(nums[i]);
        }
        for(int i = 1;i<=nums.length;i++){
            if(!hs.contains(i)){
                arr.add(i);
            }
        }  
        return arr;
    }
}