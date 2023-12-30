class MyCircularQueue {
    int size;
    ListNode head;
    int limit;
    public MyCircularQueue(int k) {
        head = null;
        size = 0;
        limit = k;
    }
    
    public boolean enQueue(int value) {
        if(size == 0){
            ListNode node = new ListNode(value);
            head = node;
            size++;
            return true;
        }
        if(size == limit){
            return false;
        }
        else{
            ListNode node = new ListNode(value);
            node.next = head;
            head = node;
            size++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        if(size == 1){
            head = null;
            size--;
            return true;
        }
        else{
            ListNode cur = head;
            ListNode dummy = head;
            while(cur.next != null){
                dummy = cur;
                cur = cur.next;
            }
            dummy.next = null;
            size--;
            return true;
        }
    }
    
    public int Front() {
        if(size == 0){
            return -1;
        }
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        return size > 0 ? cur.val : -1;
    }
    
    public int Rear() {
        return head != null ? head.val : -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == limit;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */