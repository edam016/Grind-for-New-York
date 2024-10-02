class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap();
        for(char ch : t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int i = 0;
        int j = 0;
        int count = hm.size();
        int minLength = Integer.MAX_VALUE;

        while(right < s.length()){
            if(hm.containsKey(s.charAt(right))){
                if(hm.get(s.charAt(right)) == 1){
                    count--;
                }
                hm.put(s.charAt(right), hm.get(s.charAt(right)) - 1);
            }
            if(count <= 0){
                while(count <= 0){
                    if(right - left + 1 < minLength){
                        i = left;
                        j = right;
                        minLength = right - left + 1;
                    }
                    if(hm.containsKey(s.charAt(left))){
                        if(hm.get(s.charAt(left)) == 0){
                            count++;
                        }
                        hm.put(s.charAt(left), hm.get(s.charAt(left)) + 1);
                    }
                    left++;
                }
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(i, j + 1);
    }
}