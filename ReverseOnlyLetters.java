class Solution {

    public String reverseOnlyLetters(String s) {
        int l = 0, r = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(l < r){
            while(!(Character.isLetter(sb.charAt(l))) && l < r){
                l++;
            }
            while(!(Character.isLetter(sb.charAt(r))) && l < r){
                r--;
            }
            char temp = sb.charAt(r);
            sb.setCharAt(r, sb.charAt(l));
            sb.setCharAt(l, temp);
            r--;
            l++;
        }
        return sb.toString();
    }
}