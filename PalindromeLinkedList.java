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
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<Integer>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = arr.size()-1;
        while(start < end){
            if(arr.get(start) != arr.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}