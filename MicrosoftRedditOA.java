import java.util.*;

class MicrosoftRedditOA{
    public static void main(String[] args){
        int [] c = {3,5,1,4,7};
        int m = c.length;
        String s = "aabcddcb";
        int result = solve(s, c, m);
        System.out.println(result);
        /*
         * 
         * c [] = [1,3,2]
         * a$abcba
         * a$ab$cba
         * a$a$b$cba
         * 
        */
    }
    
    public static class Triple{
        int index1;
        int index2;
        Stack<Integer> sk;

        public Triple(int index1, int index2, Stack<Integer> sk){
            this.index1 = index1;
            this.index2 = index2;
            this.sk = sk;
        }
    }

    public static int solve(String s, int[] c, int m){
        HashMap<Character, Triple> hm = new HashMap<Character, Triple>();
        for(int i =0;i<=s.length()-1;i++){
            if(hm.containsKey(s.charAt(i))){
                Stack<Integer> sk = hm.get(s.charAt(i)).sk;
                sk.push(i);
                Triple triple = new Triple(hm.get(s.charAt(i)).index1, i, sk);
                hm.put(s.charAt(i), triple);
            }
            else{
                Stack<Integer> sk = new Stack<Integer>();
                sk.push(i);
                Triple triple = new Triple(i, -1, sk);
                hm.put(s.charAt(i), triple);
            }
        }
        int index = 0;
        boolean flag = true;
        for(int i = 0;i<=c.length-1;i++){
            for(Character chr : hm.keySet()){
                if(hm.get(chr).index1 <= c[i] && hm.get(chr).index2 >= c[i]){
                    Stack<Integer> sk = hm.get(chr).sk;
                    sk.pop();
                    Triple triple = new Triple(hm.get(chr).index1, hm.get(chr).index2, sk);
                    hm.put(chr, triple);
                }
            }
            for(Character chr : hm.keySet()){
                if(hm.get(chr).sk.size() > 1){
                    flag = false;
                }
            }
            if(flag == true){
                return i  +1;
            }
            flag = true;
            index = 0;
        }
        return -1;
    }
}