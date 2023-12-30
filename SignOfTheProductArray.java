class Solution {
    public int arraySign(int[] nums) {
        boolean pos = true;
        for(int num : nums){
            if(num  == 0){
                return 0;
            }
            if(num < 0){
                pos = !pos;
            }    
        }
        return pos == true ? 1 : -1;
    }
}