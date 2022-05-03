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
        List<String> ans = new ArrayList<>();
        binaryTreePathsH(root, ans, "");
        return ans;
    }
    
    public void binaryTreePathsH(TreeNode root, List<String> ans, String oneans) {
        if(root == null){
            return;
        }
        //System.out.println(root.val);
        if(root.left == null && root.right==null){
            ans.add(oneans+root.val);
            return;
        }
        
        binaryTreePathsH(root.left, ans, oneans+root.val+"->");
        binaryTreePathsH(root.right, ans, oneans+root.val+"->");
    }
}
