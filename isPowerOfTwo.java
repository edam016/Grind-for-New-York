class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        long val = 2;
        while(val <= n){
            if(val == n){
                return true;
            }
            val = 2 * val;
        }
        return false;
    }
}