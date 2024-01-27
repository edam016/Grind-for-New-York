class Solution {
    public String longestPalindrome(String s) {
        int left, right, left2, right2;
        StringBuilder sb = new StringBuilder();
        String result = "";
        for(int i = 0;i<s.length();i++){
            left = i;
            right = i;

            while(left >= 0 && right <= s.length()-1){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                if(left == right){
                    sb.append(s.charAt(left));
                }
                else{
                    sb.insert(0, s.charAt(left));
                    sb.append(s.charAt(right));
                }
                left--;
                right++;
            }

            if(sb.length() > result.length()){
                result = sb.toString();
            }

            sb.setLength(0);
            left2 = i;
            right2 = i + 1;
            while(left2 >= 0 && right2 <= s.length()-1){
                if(s.charAt(left2) != s.charAt(right2)){
                    break;
                }
                sb.insert(0, s.charAt(left2));
                sb.append(s.charAt(right2));
                left2--;
                right2++;
            }
            if(sb.length() > result.length()){
                result = sb.toString();
            }
            sb.setLength(0);
        }
        return result;
    }
}