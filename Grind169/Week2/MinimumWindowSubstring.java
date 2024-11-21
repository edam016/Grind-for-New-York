class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character, Integer> hm = new HashMap();
        for(char ch : t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = hm.size();
        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < s.length()){
            char letter = s.charAt(right);
            if(hm.containsKey(letter)){
                if(hm.get(letter) == 1){
                    count--;
                }
                hm.put(letter, hm.get(letter) - 1);
            }

            while(count == 0 && left <= right){
                char letterL = s.charAt(left);
                if(right - left + 1 < minLength){
                    i = left;
                    j = right;
                    minLength = right - left + 1;
                }
                if(hm.containsKey(letterL)){
                    if(hm.get(letterL) == 0){
                        count++;
                        //is 0 as 0 is hit when the needed letters are hit. If positive, then letters are missing
                    }
                    hm.put(letterL, hm.get(letterL) + 1);
                }
                left++;
            }
            right++;
        }
        return minLength != Integer.MAX_VALUE ? s.substring(i, j + 1) : "";
    }
}