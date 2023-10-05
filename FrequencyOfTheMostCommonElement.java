class Solution {
    public int maxFrequency(int[] nums, int k) {
        int l = 0, r = 0, max = 0;
        long sum = 0;
        Arrays.sort(nums);
        while(r <= nums.length - 1){
            sum += nums[r];
            while(((r - l + 1 )* nums[r]) > (sum +  k)){
                sum -= nums[l];
                l++;
            }
            max = Math.max(r - l + 1, max);
            r++;
        }
        return (int)max;
    }//long is needed due to bit loss
}
