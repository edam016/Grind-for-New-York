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
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode scan = head;
        while(head.next != null){
            count++;
            head = head.next;
        }
        int middle = 0;
        while(middle < (count/2)){
            scan = scan.next;
            middle++;
        }
        return scan;
    }
}