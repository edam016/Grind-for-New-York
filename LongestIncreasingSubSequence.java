class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for(int val : nums){
            int i = 0, j = size;
            while(i < j){
                int m = (i + j)/2;
                if(tails[m] < val){
                    i = m + 1;
                }
                else{
                    j = m;
                }
            }
            tails[i] = val;
            if(i == size){
                size++;
            }
        }
        return size;
    }
}