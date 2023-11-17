class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int [] result = new int [spells.length];
        for(int i = 0;i<=spells.length-1;i++){
            long val = spells[i];
            int left = 0, right = potions.length-1;
            int middle = 0;
            while(left < right){
                middle = left + (right - left) / 2;
                long value = val * potions[middle];
                if(value >= success){
                    right = middle;
                }
                else{
                    left = middle + 1;
                }
            }
            if(left == potions.length-1){
                result[i] = 0;
                long check = potions[left] * val;
                if(check >=success){
                    result[i]++;
                }
            }
            else{
                result[i] = potions.length - left;
            }
            

        }
        return result;
    }
}