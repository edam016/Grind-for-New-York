class Solution {
    class Data{
        int left;
        int right;

        public Data(int left, int right){
            this.left = left;
            this.right = right;
        }

        public Data setRight(Data data, int right){
            data.right = right;
            return data;
        }

    }

    public int countPalindromicSubsequence(String s) {
        int total = 0;
        boolean flag = false;
        HashMap<Character, Data> hm = new HashMap();
        for(int i = 0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                Data data = hm.get(s.charAt(i));
                data = data.setRight(data, i);
                hm.put(s.charAt(i), data);
            }
            else{
                Data data = new Data(i , 0);
                hm.put(s.charAt(i), data);
            }
        }
        //use a hashset to track duplicates for 3 palidnrome sequence
        for(char ch : hm.keySet()){
            HashSet<Character> hs = new HashSet();
            for(int i = hm.get(ch).left + 1;i<hm.get(ch).right;i++){
                hs.add(s.charAt(i));
            }
            total += hs.size();
            hs.clear();
        }
        return total;
    }
}