class Trie {

    class TrieNode{
        HashMap<Integer, TrieNode> children;
        boolean isEnd;

        public TrieNode(){
            children = new HashMap();
            isEnd = false;
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int key = ch - 'a';
            if(!current.children.containsKey(key)){
                current.children.put(key, new TrieNode());
            }
            current = current.children.get(key);
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int key = ch - 'a';
            if(current.children.containsKey(key)){
                current = current.children.get(key);
            }
            else{
                return false;
            }
        }
        return current.isEnd == true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char ch : prefix.toCharArray()){
            int key = ch - 'a';
            if(current.children.containsKey(key)){
                current = current.children.get(key);
            }
            else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */