class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        if(s.length() == 0){
            return true;
        }
        for(int i = 0;i<=t.length()-1;i++){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
            if(j == s.length()){
                return true;
            }
        }
        return false;
    }
}