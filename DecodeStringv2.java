class Solution {
    public String decodeString(String s) {
        
        Stack<Character> sk = new Stack();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != ']'){
                sk.push(s.charAt(i));
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(!sk.isEmpty() && Character.isLetter(sk.peek())){
                    sb.insert(0, sk.pop());
                }
                sk.pop();
                String word = sb.toString();
                sb.setLength(0);

                while(!sk.isEmpty() && Character.isDigit(sk.peek())){
                    sb.insert(0, sk.pop());    
                }

                int times = Integer.parseInt(sb.toString());
                while(times > 0){
                    for(char ch : word.toCharArray()){
                        sk.push(ch);
                    }
                    times--;
                }
            }
        }
        StringBuilder res = new StringBuilder();

        while(!sk.isEmpty()){
            res.insert(0, sk.pop());
        }
        return res.toString();
    }
}