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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        int size = 1;
        while(cur.next != null){
            cur = cur.next;
            size++;
        }
        cur.next = head;
        int times = k % size;
        for(int i = 0;i<size - times;i++){
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}