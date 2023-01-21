class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character, Integer> letterTracking = new HashMap<Character, Integer>();
        HashMap <Character, Integer> letterTrackingT = new HashMap<Character, Integer>();
        String test = "abcdefghijklmnopqrstuvwxyz";
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(letterTracking.containsKey(s.charAt(i))){
                letterTracking.put(s.charAt(i), letterTracking.get(s.charAt(i))+1);
            }
            else{
                 letterTracking.put(s.charAt(i), 1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(letterTrackingT.containsKey(t.charAt(i))){
                letterTrackingT.put(t.charAt(i), letterTrackingT.get(t.charAt(i))+1);
            }
            else{
                 letterTrackingT.put(t.charAt(i), 1);
            }
        }

        for(int i=0;i<test.length();i++){
            if(letterTracking.get(test.charAt(i))!= null && !(letterTracking.get(test.charAt(i)).equals(letterTrackingT.get(test.charAt(i))))){
                return false;
            }
        }
        return true;
    }
}public class ValidPalindrome {
    
}
