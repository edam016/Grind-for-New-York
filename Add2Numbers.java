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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> arr = new ArrayList();

        int val1 = 0;
        int val2 = 0;
        int carry = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            else{
                val1 = 0;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            else{
                val2 = 0;
            }
            int sum = val1 + val2 + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum%10;
            }
            else{
                carry = 0;
            }
            arr.add(sum);
        }
        if(carry != 0){
            arr.add(carry);
        }
        ListNode result = new ListNode(0, null);
        ListNode head = result;
        for(int val : arr){
            ListNode node = new ListNode(val, null);
            result.next = node;
            result = result.next;
        }
        return head.next;
    }
}