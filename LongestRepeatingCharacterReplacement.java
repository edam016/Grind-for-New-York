class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int[] charCount = new int[26]; // good for keeping track of repeating characters which is common in string problems
        int maxCount = 0;
        HashMap<Character, Integer> hm = new HashMap();
        while(right < s.length()){
            charCount[s.charAt(right) - 'A']++;//Gets index using ascii characters
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);
            while(right - left + 1 - maxCount > k){
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            //window size - number of same characters is number of different chracters
            //Window does not change size if you keep adding new characters as it will remain this size due to maxChar being at max capacity and only increases when you see a character that has higher count
            /**
            
            AABACDDDDDD will be AABA and then ABAC

            AABA -> 3 - 0 + 1 - 3 = 1
            AABAC -> 4 - 0 + 1 - 3 = 2 -> ABAC
            ABAC -> 4 - 1 + 1 - 3 = 1
            ABACD -> 5 - 1 + 1 - 3 = 2 -> BACD
            BACD -> 5 - 2 + 1 - 3 = 1
            BACDD -> 6 - 2 + 1 - 3 = 2 -> ACDD
            ACDD -> 6 - 3 + 1 - 3 = 1
            ACDDD -> 7 - 3 + 1 - 3 = 2 -> CDDD
            CDDD -> 7 - 4 + 1 - 3 = 1
            CDDDD -> 8 - 4 + 1 - 4 = 1  ACHIEVED MAX LENGTH

            If new characters are more then maxChar, then it must be greater then the current maxChar value so window stays same until then
             */
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;

    }
}