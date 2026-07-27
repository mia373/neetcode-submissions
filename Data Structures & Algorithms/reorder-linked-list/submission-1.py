# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        #题目要求我们不能直接改node value，需要reorder nodes themselves
        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        #当奇数nodes时，比如1-2-3-4-5，slow停在3这
        #当偶数nodes时，比如1-2-3-4-5-6，slow停在4这
        #所以l2的长度一定小于等于l1
        l2 = self.reverseList(slow)
        l1 = head

        self.mergeTwoLists(l1, l2)

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        curr = head

        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev

    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> None:
        #不用比较大小，直接merge两个lists
        while list2.next:
            temp1 = list1.next
            temp2 = list2.next

            list1.next = list2
            list1 = temp1

            list2.next = list1
            list2 = temp2