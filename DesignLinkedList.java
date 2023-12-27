class MyLinkedList {

    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    Node head;
    int length;

    public MyLinkedList() {
        head = null;
        length = 0;
    }
    
    public int get(int index) {
        if(head == null){
            return -1;
        }
        if(index >= length){
            return -1;
        }
        else{
            int counter = 0;
            Node cur = head;
            while(counter < index){
                cur = cur.next;
                counter++;
            }
            return cur.val;
        }
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        length++;
    }
    
    public void addAtTail(int val) {
        if(length == 0){
            addAtHead(val);
        }
        else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            Node tail = new Node(val);
            cur.next = tail;
            length++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index > length){
            return;
        }
        if(index == 0){
            addAtHead(val);
        }
        else{
            Node cur = head;
            int counter = 1;
            while(counter < index){
                counter++;
                cur = cur.next;
            }
            Node add = new Node(val);
            Node temp = cur.next;
            cur.next = add;
            add.next = temp;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= length){
            return;
        }
        if(index == 0){
            head = head.next;
            length--;
        }
        else{
            Node cur = head;
            int counter = 1;
            while(counter < index){
                counter++;
                cur = cur.next;
            }
            cur.next = cur.next.next;
            length--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */