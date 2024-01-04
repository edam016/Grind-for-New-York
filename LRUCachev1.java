class LRUCache {
    class Node{
        int val;
        int key;
        Node next;
        public Node(int val, int key){
            this.val = val;
            this.key = key;
        }
    }

    Node head;
    int length;
    int maxSize;

    public LRUCache(int capacity) {
        head = null;
        length = 0;
        maxSize = capacity;
    }
    
    public int get(int key) {
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return head.key == key ? head.val :-1;
        }
        if(head.key == key){
            Node cur = head;
            Node temp = head;
            head = head.next;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = temp;
            temp.next = null;
            return temp.val;
        }
        else{
            Node newNode = head;
            Node cur = head;
            Node dummy = head;
            while(cur.next != null){
                if(cur.key == key){
                    newNode = cur;
                    dummy.next = cur.next;
                }
                dummy = cur;
                cur = cur.next;
            }
            cur.next = newNode;
            newNode.next = null;
            return newNode.key == key ? newNode.val : -1;
        }
    }
    
    public void put(int key, int value) {
        if(head == null){
            Node node = new Node(key, value);
            head = node;
            length++;
        }
        else if(length == maxSize){
            Node cur = head.next;
            while(cur.next != null){
                cur = cur.next;
            }
            Node node = new Node(key, value);
            cur.next = node;
            node.next = null;
            head = head.next;
        }
        else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            Node node = new Node(key, value);
            cur.next = node;
            length++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */