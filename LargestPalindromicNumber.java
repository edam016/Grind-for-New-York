class Solution {
    public String largestPalindromic(String num) {
        StringBuilder sb = new StringBuilder();
        int[] fmap = new int[10];
        for(char c : num.toCharArray()){
            fmap[c - '0']++;
        }
        int mid = -1;
        boolean flag = true;
        for(int i = 9;i>=0;i--){
            if(fmap[i] == 0){
                continue;
            }
            if(fmap[i] % 2 == 1 && flag){
                mid = i;
                flag = false;
            }
            if(i == 0 && sb.length() == 0){
                break;
            }
            int val = fmap[i]/2;
            while(val-- > 0){
                sb.append(i);
            }
        }
        StringBuilder rev = new StringBuilder(sb).reverse();
        sb.append(rev);
        if(mid != -1){
            sb.insert(sb.length()/2, mid);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}