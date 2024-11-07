class Solution {
    public boolean isPalindrome(String s) {
        s.trim();
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            while(left < right && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))){
                left++;
            }
            while(right > left && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))){
                right--;
            }
            if(Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}