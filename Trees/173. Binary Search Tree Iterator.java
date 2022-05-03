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
    
    LinkedList<TreeNode> stk = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        addAll(root);
    }
    
    public void addAll(TreeNode node){
        if(node==null){
            return;
        }
        
        while(node!=null){
            stk.addFirst(node);
            node = node.left;
        }
    }  
    
    public int next() {
        TreeNode node = stk.removeFirst();
        addAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return (stk.size()>0);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
