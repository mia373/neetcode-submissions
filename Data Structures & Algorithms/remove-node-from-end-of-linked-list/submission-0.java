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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++; 
        }

        int index = length - n;
        ListNode target = dummy;

        for (int i = 0; i < index; i++) {
            target = target.next;
        }

        target.next = target.next.next;

        return dummy.next; 
    }
}
