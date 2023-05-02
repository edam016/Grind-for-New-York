/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> hm = new HashMap<ListNode, Integer>();
        while(head != null && head.next != null){
            if(hm.containsKey(head) && hm.get(head) == head.val){
                return true;
            }
            else{
                hm.put(head, head.val);
            }
            head = head.next;
        }
        return false;
    }
}