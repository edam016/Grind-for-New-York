class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        HashMap<String, List<String>> hm = new HashMap();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=strs.length-1;i++){
            char [] word = strs[i].toCharArray();
            Arrays.sort(word);
            for(char a : word){
                sb.append(a);
            }
            if(hm.containsKey(sb.toString())){
                List<String> group = hm.get(sb.toString());
                group.add(strs[i]);
                hm.put(sb.toString(), group);
            }
            else{
                List<String> group = new ArrayList();
                group.add(strs[i]);
                hm.put(sb.toString(), group);
            }
            sb.setLength(0);
        }
        for(String val : hm.keySet()){
            result.add(hm.get(val));
        }
        return result;
    }
}