class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2;i<=s.length();i++){
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if(oneDigit >= 1){
                dp[i] += dp[i-1];
            }
            if(twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i - 2];
                
                /** 
                
                able to use the next digit to get the i-2 ways to decode a string
                ex. 221 -> 2,21 and 2,21 compared to 261 -> 26,1 and thats it. 
                Adding a 1 in the first example frees up the value if it is less then 26 but if not, then it does not increase the number of ways to decode it, 


                adding a 1 when the digit does not free itself etc. 2,6 adding 1, it turns to 2,6,1 and 26,1 
                same as 2,6 and 26 so there is no increasing however second example is different

                2,6 adding 1
                2,6 || 26 -> 2,6,1 || 26,1

                2,2 adding 1
                22 || 2,2 -> 2,2,1 || 22,1 || 2,21 

                */
 
            }
        }

        return dp[s.length()];
    }
}

/**

  [111106] - > [1,1,1,10,6] && [11,10,6]
  
  11-> 1,1 11

  111 -> 1,11 11,1 1,1,1

  1110 -> 1,1,10 11,10

  1111 -> 1,1,1,1 11,1,1 1,11,1 1,1,11

  1110 -> 1,1,10 11,10 

  11102 -> 11,10,2 1,1,10,2

  16156 -> 1,

  Cases 

  number added is non zero -> dp + 1
  number added is 0 -> dp - 1

 */