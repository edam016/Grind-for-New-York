/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a, b));
        for(ListNode nodes : lists){
            while(nodes != null){
                pq.offer(nodes.val);
                nodes = nodes.next;
                
            }
        }
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        while(!pq.isEmpty()){
            ListNode node = new ListNode(pq.poll(), null);
            dummy.next = node;
            dummy = dummy.next;
        }
        return result.next;
    }
}