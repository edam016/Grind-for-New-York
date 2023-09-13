class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<String>();
        List<Character> seq = new ArrayList<Character>();
        HashSet<String> result = new HashSet<String>();
        List<String> finalResult = new ArrayList<String>();
        if(s.length() < 10){
            return finalResult;
        }
        for(int i = 0;i<10;i++){
            seq.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder(seq.size());
        for(Character c : seq){
            sb.append(c);
        }
        String res = sb.toString();
        set.add(res);
        int start = 0;
        for(int i = 10;i<=s.length()-1;i++){
            seq.add(s.charAt(i));
            seq.remove(start);
        StringBuilder sb2 = new StringBuilder(seq.size());
        for(Character c : seq){
            sb2.append(c);
        }
        String res2 = sb2.toString();
            if(!set.add(res2)){
                result.add(res2);
            }
        }
        for(String val : result){
            finalResult.add(val);
        }
        return finalResult;
    }
}