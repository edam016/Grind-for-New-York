class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        if(s.length() < p.length() || p.length() == 0){
            return new ArrayList();
        }
        List<Integer> res = new ArrayList();
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        
        for(int i = 0;i<p.length();i++){
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pMap, sMap)){
            res.add(0);
        }

        int left = 0;
        int right = p.length();

        while(right < s.length()){
            sMap[s.charAt(right) - 'a']++;
            sMap[s.charAt(left) - 'a']--;
            right++;
            left++;
            if(Arrays.equals(sMap, pMap)){
                res.add(left);
            }
        }
        return res;
    }
}