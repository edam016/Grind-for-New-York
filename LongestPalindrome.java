class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        for(int i = 0;i<s.length();i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        int length = 0;
        boolean oddDetected = false;
        for(char val: hm.keySet()){
            if(hm.get(val) % 2 == 0){
                length += hm.get(val);
            }
            else if(hm.get(val) % 2 != 0){
                length += hm.get(val)-1;
                oddDetected = true;
            }
        }
        return oddDetected ? length + 1 : length;
    }
}