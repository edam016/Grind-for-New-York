class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet seen = new HashSet(), repeated = new HashSet();
        for(int i = 0;i + 9 < s.length();i++){
            String res = s.substring(i, i + 10);
            if(!seen.add(res)){
                repeated.add(res);
            }
        }  
        return new ArrayList(repeated);
    }
}