class Trie {

    class TrieNode{
        Map<Integer, TrieNode> children;
        boolean isWord;

        public TrieNode(){
            children = new HashMap();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            int key = ch - 'a';
            if(!cur.children.containsKey(key)){
                cur.children.put(key, new TrieNode());
            }
            cur = cur.children.get(key);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            int key = ch - 'a';
            if(!cur.children.containsKey(key)){
                return false;
            }
            cur = cur.children.get(key);
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            int key = ch - 'a';
            if(!cur.children.containsKey(key)){
                return false;
            }
            cur = cur.children.get(key);
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