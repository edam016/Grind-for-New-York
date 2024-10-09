class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<needle.length();i++){
            sb.append(haystack.charAt(i));
        }
        if(sb.toString().equals(needle)){
            return 0;
        }
        int left = 0;
        int right = needle.length();
        while(right < haystack.length()){
            sb.deleteCharAt(0);
            sb.append(haystack.charAt(right));
            if(sb.toString().equals(needle)){
                return left + 1;
            }
            right++;
            left++;
        }
        return -1;
    }
}