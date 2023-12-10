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
    public int pairSum(ListNode head) {
        Stack<ListNode> sk = new Stack();

        ListNode fast = head;
        ListNode slow = head;

        int maxSum = Integer.MIN_VALUE;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        while(slow != null){
            sk.push(slow);
            slow = slow.next;
        }
        slow = head;
        
        while(!sk.isEmpty()){
            ListNode node = sk.pop();
            maxSum = Math.max(node.val + slow.val, maxSum);
            slow = slow.next;
        }

        return maxSum;
    }   
}