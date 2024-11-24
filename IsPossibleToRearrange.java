class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        HashMap<String, Integer> sHm = new HashMap();
        HashMap<String, Integer> tHm = new HashMap();
        int num = s.length() / k;
        for(int i = 0;i<s.length();i+=num){
            String sub = s.substring(i, i + num);
            sHm.put(sub, sHm.getOrDefault(sub, 0) + 1);
        }

        for(int i = 0;i<t.length();i+=num){
            String sub = t.substring(i, i + num);
            if(sHm.containsKey(sub) && sHm.get(sub) > 0){
                sHm.put(sub, sHm.get(sub) - 1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}