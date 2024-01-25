class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int sum = 0;
        for(int i = 0;i<rolls.length;i++){
            sum += rolls[i];
        }
        int missing = (mean * (n + rolls.length)) - sum;
        System.out.println(missing);
        if(missing > n * 6 || missing < n){
            return new int[0];
        }
        int i = 0;
        while(missing >= 0 && i < result.length){
            int dice = Math.min(missing - n + 1, 6);
            result[i] = dice;
            missing -= dice;
            i++;
            n -= 1;
        }
        return result;
    }
}