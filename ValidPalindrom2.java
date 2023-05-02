class Solution {
    public boolean validPalindrome(String s) {
        int j = s.length()-1;
        boolean res = false;;
        int i =0;
        while(i<j){
            if(s.charAt(j) != s.charAt(i)){
                return res = Palindrome(s, i+1, j) || Palindrome(s, i, j-1);
            }
            j--;
            i++;
        }
        return true;
    }

    public boolean Palindrome(String s, int i, int k){
        int start = i;
        int end = k;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
    return true;
    }
}