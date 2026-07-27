# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        res = 0 

        def dfs(root): 
            nonlocal res

            if not root:
                return 0
            
            # Store the results instead of calling multiple times
            left = dfs(root.left)
            right = dfs(root.right)

            # Update diameter (path through this node)
            res = max(res, left + right)

            # Return height of this subtree
            return 1 + max(left, right)
            
        dfs(root)
        return res

