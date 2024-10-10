class Solution {
    public String longestCommonPrefix(String[] strs) {

        int minLength = Integer.MAX_VALUE;
        for(int i = 0;i<strs.length;i++){
            minLength = Math.min(strs[i].length(), minLength);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<minLength;i++){
            sb.append(strs[0].charAt(i));
            for(int j = 0;j<strs.length;j++){
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                    sb.deleteCharAt(sb.length()-1);
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}