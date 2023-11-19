class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int cost = 0;
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0;i<=s.length()-1;i++){
            cost += Math.abs((s.charAt(i)-'0') - (t.charAt(i)-'0'));
            count++;
            while(cost > maxCost){
                cost -= Math.abs((s.charAt(start)-'0') - (t.charAt(start)-'0'));
                count--;
                start++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}