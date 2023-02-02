class Solution {
    public boolean isValid(String s) {
        Stack<Character> stck = new Stack<Character>();
        for(int i =0;i<=s.length()-1;i++){
            if((stck.size()!=0)&& (stck.peek() == '(') && (s.charAt(i) == ')') ){
                stck.pop();
            }
            else if((stck.size()!=0)&& (stck.peek() == '[') && (s.charAt(i) == ']')){
                stck.pop();
            }
            else if((stck.size()!=0)&& (stck.peek() == '{') && (s.charAt(i) == '}')){
                stck.pop();
            }
            else{
                stck.push(s.charAt(i));
            }

        }
        return (stck.size()==0);
    }
}