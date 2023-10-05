class Solution {
    public int maxVowels(String s, int k) {
        int start = 0, vowelCount = 0, maxCount = 0;
        String vowels = "aeiou";
        List<Character> wind = new ArrayList();
        for(int i = 0;i<= s.length()-1;i++){
            if(i < k){
                wind.add(s.charAt(i));
                if(vowels.contains(String.valueOf(s.charAt(i)))){
                    vowelCount++;
                }
            }
            else{
                if(vowels.contains(String.valueOf(s.charAt(i)))){
                    vowelCount++;
                }
                if(vowels.contains(String.valueOf(s.charAt(start)))){
                    vowelCount--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, vowelCount);
        }
        return maxCount;
    }
}