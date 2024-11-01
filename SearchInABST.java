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
    public TreeNode searchBST(TreeNode root, int val) {
        List<TreeNode> arr = new ArrayList();
        dfs(root, val, arr);
        return arr.size() > 0 ? arr.get(0) : null;
    }

    public void dfs(TreeNode root, int val, List<TreeNode> arr){
        if(root == null){
            return;
        }
        else if(root.val == val){
            arr.add(root);
            return;
        }
        dfs(root.left, val, arr);
        dfs(root.right, val, arr);
    }
}