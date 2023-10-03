class Solution {
    public int minSwaps(String s) {
        int closed = 0, result = Integer.MIN_VALUE;
        for(int i = 0;i<=s.length()-1;i++){
            if(s.charAt(i) == ']'){
                closed++;
            }
            else{
                closed--;
            }
            result = Math.max(closed, result);
        }
        return (result + 1)/2;
    }
}