class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet();
        int right = 0;
        int left = 0;
        int maxLength = 0;
        while(right < s.length()){
            while(!hs.add(s.charAt(right)) && left <= right){
                hs.remove(s.charAt(left));
                left++;
            }
            right++;
            maxLength = Math.max(right - left, maxLength);
        }
        return maxLength;
    }
}