class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int maxCount = 0;

        HashMap<Character, Integer> hm = new HashMap();
        String vowel = "aeiou";
        for(char ch : vowel.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        while(right < s.length()){
            if(hm.containsKey(s.charAt(right))){
                count++;
            }
            if(right >= k){
                if(hm.containsKey(s.charAt(left))){
                    count--;
                }
                left++;
            }
            maxCount = Math.max(count, maxCount);
            right++;
        }
        return maxCount;
    }
}