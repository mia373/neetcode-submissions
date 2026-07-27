/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        // a tree is a binary search tree if every node meets the constraints.
        // for every node, its left subtree's all nodes must be less than itself. 
        // for every node, its right subtree's all nodes must be greater than itself. 

        return dfs (root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs (TreeNode node, long left, long right) {
        if (node == null) return true;

        if (!(node.val > left && node.val < right)) {
            return false;
        }

        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }
}