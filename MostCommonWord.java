class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.trim();
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hm = new HashMap();
        for(char ch : paragraph.toCharArray()){
            if(Character.isLetter(ch)){
                sb.append(ch);
            }
            else if(sb.length() > 0){
                String word = sb.toString().toLowerCase();
                if(hm.containsKey(word)){
                    hm.put(word, hm.get(word) + 1);
                }
                else{
                    hm.put(word, 1);
                }
                sb.setLength(0);
            }
        }

        if(sb.length() > 0){
            hm.put(sb.toString().toLowerCase(), hm.getOrDefault(sb.toString().toLowerCase(), 0) + 1);
        }
        for(String ban : banned){
            hm.remove(ban);
        }
        int maxVal = 0;
        String maxWord = "";
        for(String word : hm.keySet()){
            if(hm.get(word) > maxVal){
                maxWord = word;
                maxVal = hm.get(word);
            }
        }
        return maxWord;
    }
}