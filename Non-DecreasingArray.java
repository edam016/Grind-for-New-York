class Solution {
    public boolean checkPossibility(int[] nums) {
        int error = 0;
        /*
        
        In this example we are referring to [a,b,c,d].
        If we are at c and b > c.
        We must pick between b or c and which value to change. 
        If c > a and c < b then we change b to c.
        Else if c < a. Then that means c must be changed to b to keep the asending order
        1.[a,b,c,d] -> [a,c,c,d]
        2.[a,b,c,d] -> [a,b,b,d]
         */
        for(int i = 1;i<=nums.length-1;i++){
            if(nums[i-1] > nums[i]){
                error++;
                if(i-2<0 || nums[i-2] <= nums[i]){
                    nums[i-1] = nums[i];// [a,b,c,d] so here we are changing b to the value of c as we should min the values. If i=1 then we can change the value to match the first value.
                }
                else{
                    nums[i] = nums[i-1];//[a,b,c,d] so here we are changing c to have the value of b. 
                }
            }
        }
        return error <= 1;
    }
}