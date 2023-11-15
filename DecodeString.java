class Solution {
    public String decodeString(String s) {
        Stack<Integer> sk = new Stack();
        Stack<Integer> counts = new Stack();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while(index <= s.length()-1){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            }
            else if(s.charAt(index) == '['){
                sk.push(res.toString());
                res.setLength(0);
                index++;
            }
            else if(s.charAt(index) == ']'){
                StringBuilder word = new StringBuilder(sk.pop());
                int count = counts.pop();
                for(int i = 0;i<count;i++){
                    word.append(res.toString());
                }
                res = word;
                index++;
            }
            else{
                res.append(s.charAt(index));
                index++;
            }
        }
        return res.toString();
    }
}