"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        
        # First pass: create all nodes and map old nodes to new nodes
        oldToNew = {None: None}  # Handle None random pointers
        
        curr = head
        while curr:
            oldToNew[curr] = Node(curr.val)
            curr = curr.next
        
        # Second pass: set next and random pointers
        curr = head
        while curr:
            newNode = oldToNew[curr]
            newNode.next = oldToNew[curr.next]
            newNode.random = oldToNew[curr.random]
            curr = curr.next
        
        return oldToNew[head]
        