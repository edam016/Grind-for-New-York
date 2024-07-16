class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        List<Integer> arr = new ArrayList();
        int left = 0, right = nums.length-1;
        while(arr.size() < nums.length){
            arr.add(nums[left]);
            left++;
            if(left < right){
                arr.add(nums[right]);
                right--;
            }
        }
        int i = 0;
        for(int val : arr){
            result[i] = val;
            i++;
        }
        return result;
    }
}