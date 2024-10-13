class Solution {
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack();
        for(char ch : s.toCharArray()){
            if(!sk.isEmpty() && sk.peek() == '['){
                if(ch == ']'){
                    sk.pop();
                    continue;
                }
            }
            if(!sk.isEmpty() && sk.peek() == '{'){
                if(ch == '}'){
                    sk.pop();
                    continue;
                }
            }
            if(!sk.isEmpty() && sk.peek() == '('){
                if(ch == ')'){
                    sk.pop();
                    continue;
                }
            }
            sk.push(ch);
        }
        return sk.size() == 0;
    }
}