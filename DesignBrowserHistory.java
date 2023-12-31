class BrowserHistory {
    class Node{
        String val;
        Node next;
        Node prev;
        public Node(String val){
            this.val = val;
        }
    }
    Node current;

    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        current = node;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        node.prev = current;
        current.next = node;
        current = node;
    }
    
    public String back(int steps) {
        int counter = 0;
        while(counter < steps && current.prev != null){
            current = current.prev;
            counter++;
        }
        return current.val;
    }
    
    public String forward(int steps) {
        int counter = 0;
        while(counter < steps && current.next != null){
            current = current.next;
            counter++;
        }
        return current.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */