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
        ListNode last = l1;
        ListNode head = l1;
        int carry = 0;
        int num = 0;
        while(l1 != null & l2!= null){
            if(carry == 0 && (l1.val + l2.val) > 9){
                num = l1.val + l2.val;
                l1.val = (num%10);
                carry = num/10;
            }
            else if(carry != 0){
                num = l1.val + l2.val + carry;
                if(num > 9){
                    l1.val = (num%10);
                    carry = num/10;
                }
                else{
                    l1.val = num;
                    carry = 0;
                }
            }
            else{
                l1.val = (l1.val + l2.val);
            }
            last = l1;
            l1 = l1.next;
            l2 = l2.next;
            
        }

        while(l1 != null){
            if(l1.val + carry > 9){
                num = l1.val + carry;
                l1.val = num%10;
                carry = num/10;
                }
            else{
                l1.val = l1.val + carry;
                carry = 0;
            }
            last = l1;
            l1 = l1.next;
        }

        while(l2 != null){
            if(l2.val + carry > 9){
                num = l2.val + carry;
                carry = num/10;
                ListNode node = new ListNode(num%10);
                last.next = node;
                last = last.next;
                }
            else{
                ListNode node = new ListNode(l2.val + carry);
                carry = 0;
                last.next = node;
                last = last.next;
            }
            l2 = l2.next;
        }

        if(carry != 0){
            ListNode tail = new ListNode(carry);
            last.next = tail;
        }

        return head;
    }
}