class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        String max = "";
        int maxLength = 0;
        for(int i = 1;i<s.length();i++){
            String odd = checkPalindrome(s, i, i);
            String even = checkPalindrome(s, i, i+1);
            if(odd.length() > even.length()){
                if(maxLength < odd.length()){
                    maxLength = odd.length();
                    max = odd;
                }
            }
            else{
                if(maxLength < even.length()){
                    maxLength = even.length();
                    max = even;
                }
            }
        }
        return max;
    }

    public String checkPalindrome(String s, int i, int j){
        int longest = 0;
        int m = 0;
        int n = 0;
        int left = i - 1;
        int right = j;
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            if(right - left + 1 > longest){
                longest = right - left + 1;
                m = left;
                n = right;
            }
            left--;
            right++;
        }
        return s.substring(m, n + 1);
    }
}