class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> sk = new Stack();

        for(char ch : num.toCharArray()){
            while(!sk.isEmpty() && k > 0 && sk.peek() > ch){
                sk.pop();
                k--;
            }
            sk.push(ch);
        }
        while(!sk.isEmpty() && k > 0){
            sk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!sk.isEmpty()){
            sb.insert(0,sk.pop());
        }
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}