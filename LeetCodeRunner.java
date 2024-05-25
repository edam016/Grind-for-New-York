// LeetCodeRunner.java
public class LeetCodeRunner {
    public static void main(String[] args) {
        // Example usage of a LeetCode solution
        String s = "aabca";
        Solution solution = new Solution();
        int result = solution.uniqueLength3Palindrome(s);

        // Print the result
        /*
         * 
         * nums = [1,1,1], k = 3 output = 2
         * 
         * nums = [1,2,3] k = 3 output = 2
         * 
         * 
         */
        System.out.println(result);
    }
}

// Example LeetCode solution class
class Solution {

    class Data{
        int left;
        int right;
        public Data(int left, int right){
            this.left = left;
            this.right = right;
        }

        public Data(int left){
            this.left = left;
        }

    }

    public int uniqueLength3Palindrome(String s) {

        
        int total = 0;
        HashMap<Character, Data> hm = new HashMap();
        for(int i = 0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                Data data = new data(left);
                hm.put(s.charAt(i), data);
            }
            else{
                Data data = hm.get(s.charAt(i));
                data.right = i;
                hm.put(s.charAt(i), data);
            }
        }
        for(char c : hm.keySet()){
            for(int i = hm.get(c).left + 1;i<=hm.get(c).right;i++){
                if(s.charAt(i) != c){
                    total++;
                }
            }
        }
    }
}
