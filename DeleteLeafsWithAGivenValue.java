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
    //use post order traversal so leafs then parent
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){
            return root;
        }

        root.right = removeLeafNodes(root.right, target);
        root.left = removeLeafNodes(root.left, target);

        if(root.val == target && root.left == null && root.right == null){
            root = null;
        }
        return root;
    }
}