class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sk = new Stack();
        Stack<Character> sk2 = new Stack();
        String firstWord = "";
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(sk.isEmpty()){
                    continue;
                }
                else{
                    sk.pop();
                }
            }
            else{
                sk.push(s.charAt(i));
            }
        }
        for(int i = 0;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(sk2.isEmpty()){
                    continue;
                }
                else{
                    sk2.pop();
                }
            }
            else{
                sk2.push(t.charAt(i));
            }
        }
        return sk.equals(sk2);
    }
}