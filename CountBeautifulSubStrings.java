class Solution {
    public int beautifulSubstrings(String s, int k) {
        
        HashMap<String, Integer> vow = new HashMap();
        
        vow.put("a", 1);
        vow.put("e", 1);
        vow.put("i", 1);
        vow.put("o", 1);
        vow.put("u", 1);
        
        int start = 0;
        int resCount = 0;
        //To get all substrings, can do doubel for loop to get all iteratiosn of substrings
        for(int i = 0;i<=s.length()-1;i++){
            int vowelCount = 0;
            int consCount = 0;
            for(int j = i;j<=s.length()-1;j++){
                if(vow.containsKey(String.valueOf(s.charAt(j)))){
                    vowelCount++;
                }
                else{
                    consCount++;
                }
                if((vowelCount*consCount)%k  == 0 && vowelCount == consCount){
                    resCount++;
                    }
                }
        }
        return resCount;
    }
}