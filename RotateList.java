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
        List<ListNode> arr = new ArrayList();
        ListNode cur = head;
        int counter = 0;
        while(cur.next != null){
            arr.add(cur);
            cur = cur.next;
        }
        arr.add(cur);
        int times = k % arr.size();
        while(counter < times){
            ListNode last = arr.remove(arr.size()-1);
            ListNode newLast = arr.get(arr.size()-1);
            last.next = head;
            head = last;
            newLast.next = null;
            arr.add(0, last);
            counter++;
        }
        return head;
    }
}