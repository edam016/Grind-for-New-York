class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
        int maxLength = 0;
        int length = 0;
        int j=0;
        if(s.length() == 0){
            return 0;
        }
        for(int i=0;i<=s.length()-1;i++){
            if(!(hm.containsValue(s.charAt(i)))){
                hm.put(i, s.charAt(i));
                length++;
                maxLength = Math.max(maxLength, length);
            }
            else{
                while(hm.containsValue(s.charAt(i))){
                    length--;
                    hm.remove(j);
                    j++;
                }
                hm.put(i, s.charAt(i));
                length++;
            }
        }
        return maxLength;
    }
}