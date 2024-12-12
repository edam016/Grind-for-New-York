class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int[] newArr = new int[shifts.length + 1];
        int k = 1;
        for(int i = 1;i<=shifts.length;i++){
            newArr[i] = shifts[shifts.length - k]%26 + newArr[i - 1];
            k++;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0, j = newArr.length - 1;i < s.length() && j < newArr.length;i++, j--){
            int val = s.charAt(i) - 'a';
            val = (val + newArr[j])%26;
            char newVal = (char) (val + 'a');
            res.append(newVal);
        }
        return res.toString();
    }
}