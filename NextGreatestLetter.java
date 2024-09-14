class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        int middle = 0;

        while(left < right){
            middle = (left + right)/2;
            if(target < letters[middle]){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }
}