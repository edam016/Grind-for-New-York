class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

        public Node(){
            this(0,0);
        }
    }

    HashMap<Integer, Node> hm;
    Node head;
    Node tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        hm = new HashMap();
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node node = hm.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node after = node.next;
        prev.next = after;
        after.prev = prev;
    }

    public void add(Node node){
        Node prev = tail.prev;
        prev.next = node;
        tail.prev = node;
        node.prev = prev;
        node.next = tail;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            hm.put(key, node);
            remove(node);
            add(node);
        }
        else{
            size++;
            if(size > capacity){
                removeLRU();
                size--;
            }
            Node node = new Node(key, value);
            hm.put(key, node);
            add(node);
        }
    }

    public void removeLRU(){
        hm.remove(head.next.key);
        Node node = head.next.next;
        head.next = node;
        node.prev = head; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */