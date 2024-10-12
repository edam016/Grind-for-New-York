class Solution {
    public String makeGood(String s) {
        Stack<Character> sk = new Stack();

        for(char ch : s.toCharArray()){
            if(!sk.isEmpty() && (Character.isUpperCase(ch)) ^ Character.isUpperCase(sk.peek()) && Character.toUpperCase(sk.peek()) == Character.toUpperCase(ch)){
                sk.pop();
            }
            else{
                sk.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : sk){
            sb.append(ch);
        }
        return sb.toString();
    }
}