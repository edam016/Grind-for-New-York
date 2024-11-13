class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sMap = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0;i<s.length();i++){
            sMap[s.charAt(i) - 'a']++;
            sMap[t.charAt(i) - 'a']--;
        }

        for(int i = 0;i<sMap.length;i++){
            if(sMap[i] != 0){
                return false;
            }
        }
        return true;
    }
}