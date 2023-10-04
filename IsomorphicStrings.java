class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap();
        HashMap<Character, Integer> hm2 = new HashMap();
        for(int i = 0;i<=s.length()-1;i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1 + i);
            }
            else{
                hm.put(s.charAt(i), 1);
            }
            if(hm2.containsKey(t.charAt(i))){
                hm2.put(t.charAt(i), hm2.get(t.charAt(i)) + 1 + i);
            }
            else{
                hm2.put(t.charAt(i), 1);
            }
        }
        for(int i = 0;i<=s.length()-1;i++){
            if(!hm.get(s.charAt(i)).equals(hm2.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}