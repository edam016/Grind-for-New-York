class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int close = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '['){
                open++;
            }
            else{
                close++;
            }
            if(close > open){
                open++;
                close--
                swap++;
            }
        }
        return swap;
    }
}