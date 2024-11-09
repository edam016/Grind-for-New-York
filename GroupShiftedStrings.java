class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        /**
        
        Potential Solutions

        Hashmap as it allows me to group all strings under common patterns


        if I use a frequency map, I can get the itnervals between letters

        abc -> bcd

        Does only the first and last letters matter? 
        If pattern is shifting, then only first and last do matter as they determine the start and end

        In test case "abn, "aln" order does matter so we cannot just check first and last, must check each letter to get difference between all letters. So instead of doing
        first and last, iterate from front to back of letter, 

        --above does not work as the a-b-n is not consistent with a-l-n

        What if I summed the differences between all the letters? This way a-b-n... no

        a-c-e is same as a-b-e as the sum must arrive at same value njo matter what, a - e is the sum, what if I had an array of differences per letter? That could work. 
        Each string would be the differences between each letter so the array would be for abn [1, 12] and aln would be [11,2]. Must be solution here

        perhaps it is only the positioning

        aceg abcdefg, just have to make sure lengths are the same

        Check difference between first and last letter as well as the length
        Using these two criteria I can determine the shifting patterns

        Is a hashmap the best solution?

        I think subtracting first and last letter to get ASCII value is best
        //need way to get difference between letters


        Must return result in different sequences

        */

        List<List<String>> result = new ArrayList();
        HashMap<Integer, List<String>> hm = new LinkedHashMap();
        for(int i = 0;i<strings.length;i++){
            int[] diff = new int[strings[i].length() - 1];
            for(int j = 0;j<strings[i].length() - 1;j++){
                diff[j] = (strings[i].charAt(j + 1) - strings[i].charAt(j))%26;
                if(diff[j] < 0){
                    diff[j] += 26;
                }
            }
            int length = strings[i].length();
            int hashCode = Arrays.hashCode(diff);
            if(hm.containsKey(hashCode)){
                List<String> arr = hm.get(hashCode);
                arr.add(strings[i]);
                hm.put(hashCode, arr);
            }
            else{
                List<String> arr = new ArrayList();
                arr.add(strings[i]);
                hm.put(hashCode, arr);
            }
        }
        
        for(int val : hm.keySet()){
            result.add(hm.get(val));
        }
        return result;
    }
}