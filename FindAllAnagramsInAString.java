class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        HashMap<Character, Integer> word = new HashMap<Character, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i<=p.length()-1;i++){
            word.put(p.charAt(i), word.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0;
        int size = 0;
        if(s.length() == 0 || p.length() == 0){
            return result;
        }
        for(int i = 0;i<=s.length()-1;i++){
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
            size++;
            if(size > p.length()){
                if(window.get(s.charAt(left)) > 1){
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                }
                else{
                    window.remove(s.charAt(left));
                }
                left++;
                size--;
            }
            if(window.equals(word)){
                result.add(left);
            }
        }
        return result;
    }
}