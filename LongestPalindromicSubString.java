class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0;i<s.length();i++){
            String even = check(s, i, false);
            String odd = check(s, i, true);
            if(even.length() > res.length()){
                res = even;
            }
            else if(odd.length() > res.length()){
                res = odd;
            }
        }
        return res;
    }


    public String check(String s, int i, boolean flag){
        int left = i - 1;
        int right;
        StringBuilder sb = new StringBuilder();
        if(flag){
            right = i;
        }
        else{
            right = i + 1;
            sb.append(s.charAt(i));
        }
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                sb.insert(0, s.charAt(left));
                sb.append(s.charAt(right));
            }
            else{
                break;
            }
            left--;
            right++;
        }
        return sb.toString();
    }
}