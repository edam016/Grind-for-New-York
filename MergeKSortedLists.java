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
        for(int i = 0; i < lists.length;i++){
            ListNode head = lists[i];
            while(head != null){
                pq.offer(head.val);
                head = head.next;
            }
        }
        ListNode head = new ListNode(0, null);
        ListNode result = new ListNode(0, head);
        while(!pq.isEmpty()){
            ListNode node = new ListNode(pq.poll(), null);
            head.next = node;
            head = head.next;
        }
        return result.next.next;
    }
}