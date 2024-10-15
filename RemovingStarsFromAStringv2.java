class Solution {
    public String removeStars(String s) {
        Stack<Character> sk = new Stack();
        for(char ch : s.toCharArray()){
            if(!sk.isEmpty() && ch == '*'){
                sk.pop();
            }
            else{
                sk.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch :sk){
            sb.append(ch);
        }
        return sb.toString();
    }
}