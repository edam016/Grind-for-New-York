class Solution {
    public long dividePlayers(int[] skill) {
        int left = 0;
        int right = skill.length-1;
        Arrays.sort(skill);
        int val = skill[left] + skill[right];
        long total = 0;
        while(left < right){
            if(skill[left] + skill[right] != val){
                return -1;
            }
            else{
                total += skill[left] * skill[right];
                right--;
                left++;
            }
        }
        return total;
    }
}