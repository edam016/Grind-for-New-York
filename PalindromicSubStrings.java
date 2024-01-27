class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int left = 0, right = 0, left2 = 0, right2 = 1;
        for(int i = 0;i<s.length();i++){
            left = i; 
            right = i;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                count++;
                left--;
                right++;
            }
            left2 = i;
            right2 = i + 1;
            while(left2 >=0 && right2 <= s.length()-1){
                if(s.charAt(left2) != s.charAt(right2)){
                    break;
                }
                count++;
                left2--;
                right2++;
            }
        }
        return count;
    }
}