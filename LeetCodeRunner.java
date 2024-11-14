// LeetCodeRunner.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.xml.crypto.Data;

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
        // int[] nums = {-1,0,1,2,-1,-4};
        // Sums sum = new Sums();
        // List<List<Integer>> result = Sums.threeSum(nums);
        
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
                Data data = new Data(i);
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
        return total;
    }
}

class Sum{
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet();
        for(int i = 0;i<nums.length;i++){
            int left = 0;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0){
                    List<Integer> arr = new ArrayList();
                    arr.add(left);
                    arr.add(right);
                    arr.add(i);
                    Arrays.sort(arr);
                    hs.add(arr);
                    right--;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
            for(List<Integer> val : hs){
                result.add(val);
            }
        }
        return result;
    }
}


class Solution{

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

    public static uniqueLength3Pal(String s){
        int total = 0;
        HashMap<Character, Data> hm = new HashMap();
        for(int i = 0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int left = hm.get(s.charAt(i)).left;
                Data data = new Data(left, i);
                hm.put(s.charAt(i), data);
            }
            else{
                Data data = new Data(i);
                hm.put(s.charAt(i), data);
            }
        }

        for(char c : hm.keySet()){
            for(int i = hm.get(c).left+1;i<hm.get(c).right;i++){
                if(s.charAt(i) != c){
                    total++;
                }
            }
        }
        return total;
    }
}