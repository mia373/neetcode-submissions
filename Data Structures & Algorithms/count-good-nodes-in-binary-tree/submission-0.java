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
    private int res = 0;

    public int goodNodes(TreeNode root) {
        //calculate the Math.max for each path, if the node is is larger than or equal to Math.max, increment result by 1
        dfs(root, Integer.MIN_VALUE);
        return res; 
    }

    private void dfs (TreeNode node, int maxVal) {
        if (node == null) return;

        if (node.val >= maxVal) {res += 1;}
        maxVal = Math.max(maxVal, node.val);

        dfs (node.right, maxVal);
        dfs (node.left, maxVal); 
    }
}
