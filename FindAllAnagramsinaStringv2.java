class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length() || s.length() == 0){
            return new ArrayList();
        }
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        List<Integer> arr = new ArrayList();

        for(int i = 0;i<p.length();i++){
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = p.length();

        if(Arrays.equals(sMap, pMap)){
            arr.add(left);
        }
        while(right < s.length()){
            sMap[s.charAt(right) - 'a']++;
            sMap[s.charAt(left) - 'a']--;
            if(Arrays.equals(sMap, pMap)){
                arr.add(left + 1);
            }
            left++;
            right++;
        }
        return arr;
    }
}