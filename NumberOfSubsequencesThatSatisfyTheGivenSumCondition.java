class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        int[] pow = new int [nums.length];
        Arrays.sort(nums);
        Arrays.fill(pow, 1);
        for(int i = 1;i<=pow.length-1;i++){
            pow[i] = (2 * pow[i-1]) % mod;
        }
        int l = 0, r = nums.length-1, count = 0;
        while(l <= r){
            if(target >= nums[l] + nums[r]){
                count = (count + pow[r-l]) % mod;
            }
            if(nums[l] + nums[r] > target){
                r--;
            }
            else{
                l++;
            }
        }
        return count;
    }
}