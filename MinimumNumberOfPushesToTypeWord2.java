class Solution {

    class Pair{
        char letter;
        int freq;
        public Pair(char letter, int freq){
            this.letter = letter;
            this.freq = freq;
        }
    }

    public int minimumPushes(String word){
        HashMap<Character, Integer> hm = new HashMap();
        HashMap<Character, Integer> freq = new HashMap();
        int minPresses = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=word.length()-1;i++){
            if(freq.containsKey(word.charAt(i))){
                freq.put(word.charAt(i), freq.get(word.charAt(i)) + 1);
            }
            else{
                freq.put(word.charAt(i), 1);
            }
        }
        for(char ch : freq.keySet()){
            q.offer(new Pair(ch, freq.get(ch)));
        }
        while(!q.isEmpty()){    
            int value = (hm.size()/8) + 1; 
            hm.put(q.poll().letter, value);
        }
        
        for(int i = 0;i<=word.length()-1;i++){
            minPresses += hm.get(word.charAt(i));
        }
        return minPresses;
    }
}