class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length-1, sum = 0, count = 0, left = 0;
        Arrays.sort(people);
        while(l <= r){
            sum = people[l] + people[r];
            if(sum == limit){
                r--;
                l++;
                count++;
            }
            else if(sum > limit){
                count += 1;
                r--;
                left = people[l];
            }
            else{
                count++;
                l++;
                r--;
            }
        }
        return l == r ? count + 1 : count;
    }
}