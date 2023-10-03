class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0;i<=s.length()-k;i++){
            String seq = s.substring(i, i + k);
            hs.add(seq);
        }
        return hs.size() == Math.pow(2, k);
    }
}