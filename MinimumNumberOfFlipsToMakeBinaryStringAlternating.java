class Solution {
    public int minFlips(String s) {
        StringBuilder sb = new StringBuilder(s).append(s);
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for (int i = 0; i <= sb.length()-1; i++) {
            if(i % 2 == 0){
                alt1.append('1');
                alt2.append('0');
            }
            else{
                alt1.append('0');
                alt2.append('1');
            }
        }
        int diff1 = 0, diff2 = 0;
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE, minTest = 0;
        while(r <= sb.length()-1){
            if(sb.charAt(r) != alt1.charAt(r)){
                diff1++;
            }
            if(sb.charAt(r) != alt2.charAt(r)){
                diff2++;
            }
            if(r - l + 1 > s.length()){
                if(sb.charAt(l) != alt1.charAt(l)){
                    diff1--;
                }
                if(sb.charAt(l) != alt2.charAt(l)){
                    diff2--;
                }
                l++;
            }
            if(r - l + 1 == s.length()){
                minTest = Math.min(diff1, diff2);
                min = Math.min(minTest, min);
            }
            r++;
        }
        return min;
    }
}