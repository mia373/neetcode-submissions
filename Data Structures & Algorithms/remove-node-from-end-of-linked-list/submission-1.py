# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        #First iteration: count the nodes
        length = 0
        curr = head
        while curr:
            length += 1
            curr = curr.next
        
        target = length - n + 1

        #Second iteration: skip the target node
        dummy = ListNode()
        curr = dummy

        while curr:
            target -= 1
            if target == 0:
                head = head.next
            
            curr.next = head
            curr = curr.next
            if head:
                head = head.next

        return dummy.next
