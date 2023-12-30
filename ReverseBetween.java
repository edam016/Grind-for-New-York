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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        int index = 1;
        ListNode cur = head;
        HashMap<Integer, ListNode> hm = new HashMap();

        while(cur != null){
            if(index >= left){
                if(hm.containsKey(index)){
                    ListNode rep = hm.get(index);
                    int temp = cur.val;
                    cur.val = rep.val;
                    rep.val = temp;
                }
                else{
                    hm.put(right, cur);
                    right--;
                }
            }
            index++;
            cur = cur.next;
        }
        return head;
    }
}