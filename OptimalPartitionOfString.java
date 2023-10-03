class Solution {
    public int partitionString(String s) {
        HashSet<Character> hs = new HashSet();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0;i<=s.length()-1;i++){
            sb.append(s.charAt(i));
            if(!hs.add(s.charAt(i))){
                sb.setLength(0);
                i--;
                hs.clear();
                count++;
            }
        }
        if(sb.toString().length() == s.length()){
            return 1;
        }
        return count+1;
    }
}