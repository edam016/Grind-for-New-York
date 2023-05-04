class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        String value = "";
        int length = 9;
        if(s.length() < 10){
            return result;
        }
        for(int i = 0;i<=length;i++){
            value += s.charAt(i);
        }
        for(int i = 10;i<=s.length()-1;i++){
            if(hm.containsKey(value)){
                hm.put(value, hm.get(value)+1);
                if(hm.get(value) == 2){
                    result.add(value);
                }
            }
            else{
                hm.put(value, 1);
            }
            value = value.substring(1);
            value += s.charAt(i);
        }
        if(hm.containsKey(value)){
                hm.put(value, hm.get(value)+1);
                if(hm.get(value) == 2){
                    result.add(value);
                }
            }
        return result;
    }
}