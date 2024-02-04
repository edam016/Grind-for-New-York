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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        dfs(root, new StringBuilder(), result);
        return result;
    }

    public void dfs(TreeNode root, StringBuilder sb, List<String> result){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sb.append("->");
            sb.append(root.val);
            result.add(sb.substring(2, sb.length()).toString());
            return;
        }
        sb.append("->");
        sb.append(root.val);
        dfs(root.left,  new StringBuilder(sb), result);
        dfs(root.right,  new StringBuilder(sb), result);
    }
}
