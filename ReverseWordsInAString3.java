class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        List<String> arr = new ArrayList<String>(); 
        for(int i = 0;i<=s.length()-1;i++){
            if(s.charAt(i) ==' '){
                sb.append(res);
                sb.append(' ');
                res = "";
            }
            else if(i == s.length()-1){
                res = s.charAt(i) + res;
                sb.append(res);
                break;
            }
            else{
                res = s.charAt(i) + res;
            }
        }
        return sb.toString();
    }

    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            StringBuilder rev = new StringBuilder();
            rev.append(word);
            sb.append(rev.reverse()).append(" ");
        }
        return sb.toString().trim();
        
    }
}