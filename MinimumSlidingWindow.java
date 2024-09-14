class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || t.length() == 0){
            return "";
        }
        if(s.length() == 1 && t.length() == 1){
            if(s.equals(t)){
                return s;
            }
            else{
                return "";
            }
        }

        HashMap<Character, Integer> hm = new HashMap();
        
        for(char ch : t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = hm.size();
        int minLength = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while(right < s.length()){
            if(hm.containsKey(s.charAt(right))){
                if(hm.get(s.charAt(right)) == 1){
                    count--;
                }
                hm.put(s.charAt(right), hm.get(s.charAt(right)) - 1);
            }
            if(count == 0){
                while(count == 0){
                    if(minLength > right - left + 1){
                        i = left;
                        j = right;
                        minLength = right - left + 1;
                    }
                    if(hm.containsKey(s.charAt(left))){
                        int val = hm.get(s.charAt(left)) + 1;
                        hm.put(s.charAt(left), val);
                        if(val >= 1){
                            count++;
                        }
                    }
                    left++;
                }

            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(i, j + 1);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character, Integer> hm = new HashMap();

        for(char ch : t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int right = 0;
        int left = 0;
        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        int count = hm.size();

        while(right < s.length()){
            if(hm.containsKey(s.charAt(right))){
                if(hm.get(s.charAt(right)) == 1){
                    count--;
                }
                hm.put(s.charAt(right), hm.get(s.charAt(right)) - 1);
            }
            while(count == 0){
                if(minLength > right - left + 1){
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
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(i, j + 1);
    }
}