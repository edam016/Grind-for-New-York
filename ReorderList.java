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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> sk = new Stack();
        while(slow != null){
            sk.push(slow);
            slow = slow.next;
        }

        while(!sk.isEmpty()){
            ListNode node = sk.pop();
            node.next = head.next;
            head.next = node;
            head = head.next.next;
        }
        head.next = null;
    }
}