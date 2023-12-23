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
    public ListNode swapNodes(ListNode head, int k) {
        int index = 0;
        int size = 0;
        ListNode check = head;
        ListNode front = head;
        while(check != null){
            size++;
            check = check.next;
        }
        int removal = size - k;
        ListNode val1 = new ListNode(-1, null);
        ListNode val2 = new ListNode(-1, null);
        while(front != null){
            if(index == removal){
                val1 = front;
            }
            if(index == k - 1){
                val2 = front;
            }
            if(val1.val >= 0 && val2.val >= 0 ){
                int temp = val1.val;
                val1.val = val2.val;
                val2.val = temp;
                break;
            }
            index++;
            front = front.next;
        }
        return head;
    }
}