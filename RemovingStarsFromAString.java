class Solution {
    public String removeStars(String s) {
        Stack<Character> sk = new Stack<Character>();
        for(int i = 0; i<=s.length()-1;i++){
            if(s.charAt(i) == '*'){
                sk.pop();
            }
            else{
                sk.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char b : sk){
            sb.append(b);
        }
        return sb.toString();
    }
}