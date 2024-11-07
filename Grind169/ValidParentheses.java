class Solution {
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack();
        for(int i = 0;i<s.length();i++){
            if(sk.isEmpty()){
                sk.push(s.charAt(i));
            }
            else if(s.charAt(i) == ']'){
                if(sk.peek() != '['){
                    return false;
                }
                sk.pop();
            }
            else if(s.charAt(i) == '}'){
                if(sk.peek() != '{'){
                    return false;
                }         
                sk.pop();
            }
            else if(s.charAt(i) == ')'){
                if(sk.peek() != '('){
                    return false;
                }
                sk.pop();
            }
            else{
                sk.push(s.charAt(i));
            }
        }
        return sk.isEmpty();
    }
}