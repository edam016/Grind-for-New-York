class Solution {
    public int lengthOfLastWord(String s) {
        int index = 0;
        int count = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(Character.isLetter(s.charAt(i))){
                index = i;
                break;
            }
        }
        for(int i = index;i>=0;i--){
            if(!Character.isLetter(s.charAt(i))){
                break;
            }
            count++;
        }
        return count;
    }
}