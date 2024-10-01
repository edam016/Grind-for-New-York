class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right < s.length()){
            while(!hs.add(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        return maxLength;
    }
}