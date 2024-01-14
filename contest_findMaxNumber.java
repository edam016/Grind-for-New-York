class Solution {
    public long findMaximumNumber(long k, int x) {
        long cost = 0;
        int count = 1;
        int factor = x;
        long result = 0;
        while(cost <= k){
            String sb = Integer.toBinaryString(count);
            StringBuilder bin = new StringBuilder(sb);
            bin.reverse();
            while(factor - 1 < bin.length()){
                cost += (long) (bin.charAt(factor-1) -'0');
                factor = factor + x;
            }
            if(cost > k){
                return result;
            }

            result = count;
            count++;
            factor = x;
        }
        return count;
    }
}