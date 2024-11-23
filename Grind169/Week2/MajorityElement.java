class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ret = 0;
        for(int num : nums){
            if(count == 0){
                ret = num;
            }
            if(ret != num){
                count--;
            }
            else{
                count++;
            }
        }
        return ret;
        //This works because count will be increased to an amount greater then n/2 times so when every other element decrements the count of it, all other elements combined still leave count > 0
    }
}