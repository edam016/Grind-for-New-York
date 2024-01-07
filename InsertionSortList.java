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
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode elem = head.next;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode index = head;
        while(elem != null){
            ListNode cur = elem;
            elem = elem.next;
            if(cur.val > index.val){
                cur = cur.next;
                index = index.next;
                continue;
            }
            while(cur.val > prev.next.val){
                prev = prev.next;
            }
            index.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            prev = dummy;
        }
        return dummy.next;
    }
}