class Solution {
    public List<String> letterCombinations(String digits) {
       HashMap<Character, String> hm = new HashMap();
       if(digits.length() == 0){
        return new ArrayList();
       }
       List<String> result = new ArrayList();
       hm.put('2', "abc"); 
       hm.put('3', "def"); 
       hm.put('4', "ghi"); 
       hm.put('5', "jkl"); 
       hm.put('6', "mno"); 
       hm.put('7', "pqrs"); 
       hm.put('8', "tuv"); 
       hm.put('9', "wxyz");
       backtrack(digits, result, hm, new StringBuilder(), 0);
       return result;
    }

    public void backtrack(String digits, List<String> result, HashMap<Character, String> hm, StringBuilder cand, int index){
        if(cand.length() == digits.length() || index >= digits.length()){
            result.add(cand.toString());
            return;
        }
        for(int i = 0;i<hm.get(digits.charAt(index)).length();i++){
            cand.append(hm.get(digits.charAt(index)).charAt(i));
            backtrack(digits, result, hm, cand, index + 1);
            cand.deleteCharAt(cand.length()-1);
        }
    }
}