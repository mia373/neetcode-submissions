# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        curr = dummy
        carryover = 0

        while l1 and l2:
            total = l1.val + l2.val + carryover
            moduler = total % 10
            carryover = total // 10

            curr.next = ListNode(moduler)

            curr = curr.next
            l1 = l1.next
            l2 = l2.next

        while l1:
            total = l1.val + carryover
            moduler = total % 10
            carryover = total // 10

            curr.next = ListNode(moduler)

            curr = curr.next
            l1 = l1.next

        while l2: 
            total = l2.val + carryover
            moduler = total % 10
            carryover = total // 10

            curr.next = ListNode(moduler)

            curr = curr.next
            l2 = l2.next

        if carryover != 0:
            curr.next = ListNode(carryover)

        return dummy.next
            