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
        #所以l2的长度一定大于等于l1
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

    #因为reorderList不能有return value，所以这个method也不能有return value
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> None:
        #不用比较大小，直接merge两个lists
        #为什么while条件里只有l2? 因为l1没有null terminate所以做不了while condition
        #为什么list2.next不是list2? 因为l2的长度一定大于等于l1且l2的最后一个node一定在尾部
        #E.g.我们merge 1-2 和 5-4-3时，当list2在3时，这个linked list已经是1-5-2-4-3了,所以当3.next is None时即终止merge
        #E.g.我们merge 1-2-3 和 6-5-4时，当list2在4时，这个linked list是1-6-2-5-3和4了, 但是因为list1没有null terminate, 
        #其实3.next还是指向4. 所以当4.next is None时即终止merge
        while list2.next:
            temp1 = list1.next
            temp2 = list2.next

            list1.next = list2
            list1 = temp1

            list2.next = list1
            list2 = temp2