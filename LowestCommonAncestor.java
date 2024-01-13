/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    HashSet<TreeNode> hs;
    TreeNode last = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hs = new HashSet();
        dfs(root, p);
        dfs(root, q);
        return last;

    }

    public void dfs(TreeNode root, TreeNode p){
        if(root == null){
            return;
        }
        if(!hs.add(root)){
            last = root;
        }
        if(root.val > p.val){
            hs.add(root);
            dfs(root.left, p);
        }
        else if(root.val < p.val){
            hs.add(root);
            dfs(root.right, p);
        }
    }
}