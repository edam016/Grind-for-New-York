class Solution {
    HashMap<Character, String> hm;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList();
        hm = new HashMap();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        recursive(digits, result, 0, sb);
        return result;
    }

    public void recursive(String Digits, List<String> result, int digIndex, StringBuilder temp){
        if(temp.length() == Digits.length()){
            result.add(temp.toString());
            return;
        }

        if(digIndex >= Digits.length() ){
            return;
        }

        for(int i = 0;i<hm.get(Digits.charAt(digIndex)).length();i++){
            String val = hm.get(Digits.charAt(digIndex));
            temp.append(val.charAt(i));
            recursive(Digits, result, digIndex + 1, temp);
            temp.deleteCharAt(temp.length()-1); 
        }
    }
}