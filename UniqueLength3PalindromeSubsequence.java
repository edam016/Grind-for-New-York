class Solution {
    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        
        for(int i = 0;i<=s.length()-1;i++){
            char ch = s.charAt(i);
            first[ch - 'a'] = Math.min(first[ch - 'a'], i); 
            last[ch - 'a'] = i;
        }
        int result = 0;
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0;i<26;i++){
            if(first[i] != Integer.MAX_VALUE && last[i] - first[i] > 1){
                hs.clear();
                for(int j = first[i] + 1;j <last[i];j++){
                    hs.add(s.charAt(j));
                }
                result += hs.size();
            }
        }
        return result;
    }
}