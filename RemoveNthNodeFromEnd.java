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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode check = head;
        int size = 0;
        while(check != null){
            size++;
            check = check.next;
        }
        int removal = size - n;
        int index = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode rem = head;
        ListNode prev = dummy;
        while(rem != null){
            if(index == removal){
                prev.next = rem.next;
                break;
            }
            prev = rem;
            rem = rem.next;
            index++;
        }
        if(removal == 0){
            return prev.next;
        }
        return head;
    }
}