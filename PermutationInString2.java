class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int right = s1.length();
        int left = 0;

        int[] fMap1 = new int[26];
        int[] fMap2 = new int[26];

        for(int i = 0;i<s1.length();i++){
            fMap1[s1.charAt(i) - 'a']++;
            fMap2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(fMap1, fMap2)){
            return true;
        }

        while(right < s2.length()){
            fMap2[s2.charAt(right) - 'a']++;
            fMap2[s2.charAt(left) - 'a']--;
            if(Arrays.equals(fMap2, fMap1)){
                return true;
            }
            right++;
            left++;
        }
        return false;
    }
}