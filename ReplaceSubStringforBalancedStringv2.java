class Solution {
    public int balancedString(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('Q', 0);
        hm.put('W', 0);
        hm.put('E', 0);
        hm.put('R', 0);
        int maxVal = s.length()/4;
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        if(hm.get('Q') <= maxVal && hm.get('W') <= maxVal && hm.get('E') <= maxVal && hm.get('R') <= maxVal){
            return 0;
        }
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < s.length()){
            hm.put(s.charAt(right), hm.get(s.charAt(right)) - 1);
            while(hm.get('Q') <= maxVal && hm.get('W') <= maxVal && hm.get('E') <= maxVal && hm.get('R') <= maxVal){
                minLength = Math.min(minLength, right - left + 1);
                hm.put(s.charAt(left), hm.get(s.charAt(left)) + 1);
                left++;
            }
            right++;
        }

        return minLength;
    }
}