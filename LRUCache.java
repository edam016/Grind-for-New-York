class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        } 
        public Node(){
            this(0, 0);
        }
    }
    
    Node head;
    Node tail;
    int capacity;
    int length;
    HashMap<Integer, Node> hm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        hm = new HashMap();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node node = hm.get(key);
        Node prev = node.prev;
        Node next = node.next;
        node.prev.next = next;
        node.next.prev = prev;

        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
        return hm.get(key).val;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
        length++;
        if(length > capacity || hm.containsKey(key)){
            Node rem;
            if(hm.containsKey(key)){
                rem = hm.get(key);
                hm.remove(key);
            }
            else{
                rem = tail.prev;
                hm.remove(rem.key);
            }
            Node prev = rem.prev;
            Node next = rem.next;
            rem.prev.next = next;
            rem.next.prev = prev;
            length--;
        }
        hm.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);

Put Cases
1. Adding value when full
2. Adding value when key already exists
3. Adding value when not full


 */

 