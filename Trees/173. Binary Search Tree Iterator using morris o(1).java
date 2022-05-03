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
class BSTIterator {
    TreeNode curr = null;

    public BSTIterator(TreeNode root) {
        this.curr = root;
    }
    
    public TreeNode getRightMost(TreeNode right, TreeNode curr){
        while(right.right!=null && right.right!=curr){
            right = right.right;
        }
        return right;
    }
    
    public TreeNode morrisT(){
        
        TreeNode ans = null;
        
        while(curr!=null){
            TreeNode left = curr.left;
            
            if(left==null){
                ans = curr;
                curr = curr.right;
                break;
            } else {
                TreeNode rmn = getRightMost(left, curr);
                
                if(rmn.right==null){
                    rmn.right = curr;
                    curr = curr.left;
                } else {
                    ans = curr;
                    curr = curr.right;
                    break;
                }
            }
        }
        return ans;
    }
    
    public int next() {
        return morrisT();
    }
    
    public boolean hasNext() {
        return (curr!=null);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
