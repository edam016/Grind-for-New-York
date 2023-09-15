class Solution {
    public int strStr(String haystack, String needle) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put(needle, needle);
        for(int i = 0;i <= haystack.length()-needle.length();i++){
            String sub = haystack.substring(i, i + needle.length());
            if(hm.containsKey(sub)){
                return i;
            }
        }
        return -1;
    }
}