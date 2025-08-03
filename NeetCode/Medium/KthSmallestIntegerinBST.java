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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2];
        result[0] = k;
        dfs(root, result);
        return result[1];
    }

    private void dfs(TreeNode node, int[] result) {
        if (node == null) {
            return;
        }

        dfs(node.left, result);
        result[0] -= 1;
        if (result[0] == 0) {
            result[1] = node.val;
            return;
        }
        dfs(node.right, result);
    }
}
