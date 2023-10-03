class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length-1, count = 0, sum = 0;
        Arrays.sort(people);
        while(l < r){
            sum = people[l] + people[r];
            if(sum > limit){
                r--;
                count++;
            }
            else{
                count++;
                r--;
                l++;
            }
        }
        return l == r ? count + 1 : count;
    }
}