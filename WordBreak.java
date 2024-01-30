class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || s == null){
            return false;
        }
        if(wordDict.size() == 0 || s.length() == 0){
            return false;
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(dp[j] == true && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}