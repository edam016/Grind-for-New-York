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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int size = 0;
        while(cur != null){
            size++;
            cur = cur.next;

        }
        cur = head;
        int groupSize =(int)Math.ceil(size / k);
        int extra = size % k;
        int valEx = extra;
        ListNode[] result;
        if(k == 1){
            result = new ListNode[k];
            result[0] = head;
            return result;
        }
        else if(k >= size){
            result = new ListNode[k];
            for(int i = 0;i<=result.length-1;i++){
                if(cur == null){
                    break;
                }
                ListNode node = new ListNode(cur.val);
                result[i] = node;
                cur = cur.next;
            }
        }
        else{
            result = new ListNode[k];
            cur = head;
            int index = 0;
            for(int i = 0;i<=size-1;i++){
                if(cur.next == null){
                    result[index] = head;
                    break;
                }
                if(extra > 0 && ((i + 1) % (groupSize+1)) == 0){
                    ListNode temp = cur.next;
                    cur.next = null;
                    result[index] = head;
                    head = temp;
                    cur = head;
                    index++;
                    extra--;
                }
                else if(extra == 0 &&( (i+1-valEx) % groupSize == 0 || cur.next == null)){
                    ListNode temp = cur.next;
                    cur.next = null;
                    result[index] = head;
                    head = temp;
                    cur = head;
                    index++;
                }
                else{
                    cur = cur.next;
                }
            }
        }

        return result;
    }
}