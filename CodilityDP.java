// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        if(A.length == 0 || A == null){
            return 0;
        }
        if(A.length == 1){
            return A[0];
        }
        if(A.length == 2){
            return A[0] + A[1];
        }
        int[] dp = new int[A.length];
        dp[0] = A[0];
        dp[1] = dp[0] + A[1];
        for(int i = 2;i<A.length;i++){
            int j = i-1;
            if(i < 6){
                dp[i] = A[i] + dp[0];
            }
            else{
                dp[i] = A[i] + dp[i-6];
            }
            while(j >= 0 && j >= i - 6){
                dp[i] = Math.max(dp[i], dp[j] + A[i]);
                j--;
            }
        }

        return dp[dp.length-1];
    }
}
