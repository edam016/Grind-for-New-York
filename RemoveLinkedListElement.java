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
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode tip = new ListNode(0, head);
        ListNode res = tip;
        while(node != null){
            if(node.val == val){
                tip.next = tip.next.next;
                node = tip.next;
            }
            else{
                node = node.next;
                tip = tip.next;
            }
        }
        return res.next;
    }
}