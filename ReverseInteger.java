class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        int result = 0;
        x = Math.abs(x);
        while(x > 0){
            int digit = x%10;
            x = x/10;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit >= Integer.MAX_VALUE%10)){
                return 0;
            }
            result = result*10 + digit;
        }
        return isNeg ? -result : result;
    }
}