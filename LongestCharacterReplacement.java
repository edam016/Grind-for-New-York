class Solution {
    public int characterReplacement(String s, int k) {
        int right = 0;
        int left = 0;
        int[] fMap = new int[26];
        int maxLength = 0;
        int maxChar = 0;

        while(right < s.length()){
            fMap[s.charAt(right) - 'A']++;
            maxChar = Math.max(maxChar, fMap[s.charAt(right) - 'A']);
            while(right - left + 1 - maxChar > k){
                fMap[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}