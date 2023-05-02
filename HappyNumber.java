class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hm = new HashSet<Integer>();
        int result = 0;
        while(hm.add(n)){
            result = 0;
            while(n>0){
                result += ((n%10)*(n%10));
                n = n/10;
            }
            if(result == 1){
                return true;
            }
            n = result;
        }
        return false;
    }
}