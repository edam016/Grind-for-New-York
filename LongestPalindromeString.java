class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        boolean oddFound = false;
        int length = 0;
        for(char ch : s.toCharArray()){
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) + 1);
            }
            else{
                hm.put(ch, 1);
            }
        }
        
        for(char ch : hm.keySet()){
            if(hm.get(ch) >= 2){
                if(hm.get(ch) % 2 == 0){
                    length += hm.get(ch);
                }
                else{
                    length += hm.get(ch) - 1;
                }
            }
            if(hm.get(ch) % 2 != 0){
                oddFound = true;
            }
        }
        return oddFound ? length + 1 : length;
    }
}