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
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        List<Integer> below = new ArrayList();
        List<Integer> above = new ArrayList();
        while(cur != null){
            if(cur.val < x){
                below.add(cur.val);
            }
            else{
                above.add(cur.val);
            }
            cur = cur.next;
        }
        cur = head;
        int counter = 0;
        while(counter < below.size()){
            cur.val = below.get(counter);
            counter++;
            cur = cur.next;
        }
        counter = 0;
        while(counter < above.size()){
            cur.val = above.get(counter);
            counter++;
            cur = cur.next;
        }
        return head;
    }
}