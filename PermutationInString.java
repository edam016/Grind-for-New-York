class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap();
        populate(s1, hm);    /**Solution was quite slow at O(n) */
        int j = 0;
        for(int i = 0;i<=s2.length()-1;i++){
            if(hm.containsKey(s2.charAt(i))){
                if(hm.get(s2.charAt(i)) > 1){
                    hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
                }
                else{
                    hm.remove(s2.charAt(i));
                }
            }
            else{
                if(hm.size() == 0){
                    return true;
                }
                else{
                    hm.clear();
                    populate(s1, hm);
                    j++;
                    i = j-1;
                }
            }
        }
        return hm.size() == 0 ? true : false;
    }
    public void populate(String s1, HashMap<Character, Integer> hm){
        for(int i = 0;i<=s1.length()-1;i++){
            if(hm.containsKey(s1.charAt(i))){
                hm.put(s1.charAt(i), hm.get(s1.charAt(i)) + 1);
            }
            else{
                hm.put(s1.charAt(i), 1);
            }
        }
    }
//OPTIIMAL SOLUTION BELOW

        public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0;i<=s1.length()-1;i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;A
        }

        if(Arrays.equals(arr1, arr2)){
            return true;
        }
        int front = 0;
        int back = s1.length();
        while(back < s2.length()){
            arr2[s2.charAt(front) - 'a']--;
            arr2[s2.charAt(back) - 'a']++;

            if(Arrays.equals(arr2, arr1)){
                return true;
            }
            front++;
            back++;
        }
        return false;
    }
}