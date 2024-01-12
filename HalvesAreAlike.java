class Solution {
    public boolean halvesAreAlike(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length()/2;i++){
            sb.append(s.charAt(i));
        }
        String a = sb.toString();
        sb.setLength(0);
        for(int i = s.length()/2;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        String b = sb.toString();
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('a', 1);
        hm.put('e', 1);
        hm.put('i', 1);
        hm.put('o', 1);
        hm.put('u', 1);
        int aCount = 0;
        int bCount = 0;
        for(int i = 0;i<=a.length()-1;i++){
            if(hm.containsKey(Character.toLowerCase(a.charAt(i)))){
                aCount++;
            }
            if(hm.containsKey(Character.toLowerCase(b.charAt(i)))){
                bCount++;
            }
        }
        return aCount == bCount;
    }
}