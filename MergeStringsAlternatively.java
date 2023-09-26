class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i <= word1.length()-1 && j <= word2.length()-1){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i <= word1.length()-1 ){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j <= word2.length()-1){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}