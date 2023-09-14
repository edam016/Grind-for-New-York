class Solution {
    HashMap<String, String> hm = new HashMap<String, String>();
    public boolean hasAllCodes(String s, int k) {
        dfs("", k);
        for(int i = 0;i<=s.length()-k;i++){
            String seq = s.substring(i, i + k);
            if(hm.containsKey(seq)){
                hm.remove(seq);
            }
        }
        return hm.size() == 0;
    }

    public void dfs(String val, int k){
        if(val.length() == k){
            hm.put(val, val);;
        }
        else{
            String z = val + "0";
            String o = val + "1";
            dfs(z, k);
            dfs(o, k);
        }
    }
}