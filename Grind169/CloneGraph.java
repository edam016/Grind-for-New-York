/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> hm = new HashMap();
    
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        return dfs(node);
    }

    public Node dfs(Node currentNode){
        if(hm.containsKey(currentNode)){
            return hm.get(currentNode);
        }

        Node clone = new Node(currentNode.val);
        //arraylist is autoinstantiated
        hm.put(currentNode, clone);

        for(Node neighbor : currentNode.neighbors){
            clone.neighbors.add(dfs(neighbor));
        }

        return clone;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Node, Node> containedNodes = new HashMap();
        Queue<Node> q = new LinkedList();
        Node clone = new Node(node.val);
        containedNodes.put(node, clone);
        q.offer(node);
        
        while(!q.isEmpty()){
            Node current = q.poll();
            for(Node neighbor : current.neighbors){
                if(!containedNodes.containsKey(neighbor)){
                    Node neighborClone = new Node(neighbor.val);
                    containedNodes.put(neighbor, neighborClone);
                    q.offer(neighbor);
                }
                containedNodes.get(current).neighbors.add(containedNodes.get(neighbor));
            }
        }
        return containedNodes.get(node);
    }
}