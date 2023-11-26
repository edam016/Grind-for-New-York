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
    public ListNode reverseList(ListNode head) {
        List<Integer> arr = new ArrayList();
        ListNode node = head;
        ListNode result = head;
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }

        for(int i = arr.size()-1;i>=0;i--){
            node.val = arr.get(i);
            node = node.next;
        }
        return result;
    }
}