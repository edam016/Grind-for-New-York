class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, List<Integer>> hm1 = new HashMap();
        HashMap<Character, List<Integer>> hm2 = new HashMap();
        for(int i = 0;i<s.length();i++){
            if(hm1.containsKey(s.charAt(i))){
                List<Integer> arr = hm1.get(s.charAt(i));
                arr.add(i);
                hm1.put(s.charAt(i), arr);
            }
            else{
                List<Integer> arr = new ArrayList();
                arr.add(i);
                hm1.put(s.charAt(i), arr);
            }
            if(hm2.containsKey(t.charAt(i))){
                List<Integer> arr = hm2.get(t.charAt(i));
                arr.add(i);
                hm2.put(t.charAt(i), arr);
            }
            else{
                List<Integer> arr = new ArrayList();
                arr.add(i);
                hm2.put(t.charAt(i), arr);
            }
        }
        for(int i = 0;i<s.length();i++){
            if(!hm1.get(s.charAt(i)).equals(hm2.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}