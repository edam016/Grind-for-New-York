class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i = 0;i<=g.length-1;i++){
            for(int j = 0;j<=s.length-1;j++){
                if(g[i] <= s[j]){
                    s[j] = -1;
                    break;
                }
            }
        }
        int res = 0;
        for(int val : s){
            if(val == -1){
                res++;
            }
        }
        return res;
    }
}