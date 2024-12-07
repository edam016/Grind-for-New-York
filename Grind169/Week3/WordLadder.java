class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> wordSet = new HashSet(wordList);
        HashSet<String> hs = new HashSet();
        Queue<String> q = new LinkedList();
        q.offer(beginWord);
        int count = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return count;
                }
                if(hs.add(word)){
                    check(word, wordSet, q, hs);
                }
            }
            count++;
        }
        return 0;
    }

    public void check(String beginWord, Set<String> wordSet, Queue<String> q, HashSet<String> hs){
        int i = 0;
        int diff = 0;

        for(String cand : wordSet){
            while(i < beginWord.length() && i < cand.length()){
                if(beginWord.charAt(i) != cand.charAt(i)){
                    diff++;
                }
                if(diff > 1){
                    break;
                }
                i++;
            }
            if(diff <= 1 && !beginWord.equals(cand)){
                q.offer(cand);
            }
            diff = 0;
            i = 0;
        }
    }
}