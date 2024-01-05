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
        //performing binary search on array to find value which would make it not ascending as binary search array must be sorted. Then it would replace the problematic portion to keep it ascending hence 
        //a subsequence
    }
}