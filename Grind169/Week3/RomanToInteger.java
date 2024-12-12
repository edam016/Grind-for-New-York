class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int sum = 0;
        Stack<Character> sk = new Stack();
        for(char ch : s.toCharArray()){
            if(!sk.isEmpty() && hm.get(sk.peek()) < hm.get(ch)){
                int val = hm.get(ch) - hm.get(sk.peek());
                sum -= hm.get(sk.peek());
                sum += val;
                continue;
            }
            sk.push(ch);
            sum += hm.get(ch);
        }
        return sum;
    }
}