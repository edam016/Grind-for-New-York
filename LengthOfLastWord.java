class Solution {
    public int lengthOfLastWord(String s) {
        boolean flag = false;
        int total = 1;
        for(int i =s.length()-1;i>=0;i--){
            if(!flag &&Character.isLetter(s.charAt(i))){
                flag = true;
            }
            else if(Character.isLetter(s.charAt(i))){
                total++;
            }
            else if(flag && (!Character.isLetter(s.charAt(i)))){
                break;
            }
        }
        return total;
    }
}