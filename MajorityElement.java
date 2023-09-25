class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        int result = 0;
        for(int i = 0;i<=nums.length-1;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
            else{
                hm.put(nums[i], 1);
            }
        }
        for(int arr : hm.keySet()){
            if(hm.get(arr)>nums.length/2){
                result = arr;
            }
        }
        return result;
    }
}