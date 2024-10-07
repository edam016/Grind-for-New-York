class Solution {
    public int balancedString(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        int right = 0;
        int left = 0;
        int max = s.length()/4;
        int minLength = Integer.MAX_VALUE;

        hm.put('Q', 0);
        hm.put('W', 0);
        hm.put('E', 0);
        hm.put('R', 0);

        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        if(hm.get('Q') <= max && hm.get('W') <= max && hm.get('E') <= max && hm.get('R') <= max){
            return 0;
        }
        while(right < s.length()){
            hm.put(s.charAt(right), hm.get(s.charAt(right)) - 1);
            while(hm.get('Q') <= max && hm.get('W') <= max && hm.get('E') <= max && hm.get('R') <= max && left <= right){
                hm.put(s.charAt(left), hm.get(s.charAt(left)) + 1);
                minLength = Math.min(right - left + 1, minLength);
                left++;
            }
            right++;
        }
        return minLength;
    }
}