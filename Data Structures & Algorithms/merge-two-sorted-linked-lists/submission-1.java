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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) { 
        ListNode dummy = new ListNode(0);
        ListNode node = dummy; 

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }

            node = node.next; 
        }
        
        // At least one of list1 and list2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2; 
        }

        return dummy.next; 
    }     
}