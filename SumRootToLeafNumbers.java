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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<String> result = new ArrayList();
        int total = 0;
        dfs(root, new StringBuilder(), result);
        for(String val : result){
            total += Integer.parseInt(val);
        }
        return total;
    }

    public void dfs(TreeNode root, StringBuilder sb, List<String> result){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sb.append(root.val);
            result.add(sb.toString());
            return;
        }
        sb.append(root.val);
        dfs(root.left, new StringBuilder(sb), result);
        dfs(root.right, new StringBuilder(sb), result);
    } 
}