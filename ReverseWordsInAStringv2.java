class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String result = "";
        Stack<String> sk = new Stack();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=s.length();i++){
            if(i < s.length() && s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
            else{
                if(sb.length() == 0){
                    continue;
                }
                sk.push(sb.toString());
                sb.setLength(0);
            }
        }

        while(!sk.isEmpty()){
            result += sk.pop();
            result += ' ';
        }
        return result.trim();
    }
}