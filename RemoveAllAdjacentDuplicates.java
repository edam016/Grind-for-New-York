class Solution {
    public String removeDuplicates(String s, int k) {
        class Pair{
            char letter;
            int count;
            Pair(char letter, int count){
                this.letter = letter;
                this.count = count;
            }
        }
        StringBuilder result = new StringBuilder();
        Stack<Pair> sk = new Stack();
        for(char ch : s.toCharArray()){
            if(sk.isEmpty() || ch != sk.peek().letter){
                Pair pair = new Pair(ch, 1);
                sk.push(pair);
            }
            else{
                Pair pair = sk.pop();
                pair.count++;
                sk.push(pair);
            }
            while(!sk.isEmpty() && sk.peek().count >= k){
                sk.pop();
            }
        }
        for(Pair elem : sk){
            int count = 0;
          for (int i = 0; i < elem.count; i++) {
                result.append(elem.letter);
            }
        }
        return result.toString();
    }
}