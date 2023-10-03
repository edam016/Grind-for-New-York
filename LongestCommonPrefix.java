class Solution {
    public String longestCommonPrefix(String[] strs) {
        char [] letters = new char[26];
        StringBuilder sb = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for(int i = 0;i<=strs.length-1;i++){
            minLength = Math.min(strs[i].length(), minLength);
        }
        for(int i = 0;i<=minLength-1;i++){
            char letter = strs[0].charAt(i);
            for(int j = 0;j<=strs.length-1;j++){
                if(strs[j].charAt(i)!=letter){
                    return sb.toString();
                }
            }
            sb.append(letter);
        }
        return sb.toString();
    }
}