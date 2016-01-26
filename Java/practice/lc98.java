/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        //use Long.MAX_VALUE to solve Integet.MAX_VALUE case
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long lb, long rb){
        if(root == null) return true;
        else if(lb<root.val&&root.val<rb) return isValid(root.left,lb,root.val)&&isValid(root.right,root.val, rb);
        else return false;
    }
        
        //inorder traverse
        /*Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while(p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else{
                TreeNode temp = stack.pop();
                p=temp.right;
                if(pre!=null&&temp.val<=pre.val) return false;
                pre=temp;
            }
        }
        return true;
    }*/
        
        
        /*
        if(root==null) return true;
        return isValid(root.left,null,root)&&isValid(root.right,root,null);
    }
    public boolean isValid(TreeNode root, TreeNode lb, TreeNode rb){
        if(root==null) return true;
        if(lb==null&&rb==null) return true;
        else if(lb==null){
            if(root.val<rb.val) return isValid(root.left,lb,root)&&isValid(root.right,root,rb);
            else return false;
        }else if(rb==null){
            if(root.val>lb.val) return isValid(root.left,lb,root)&&isValid(root.right,root,rb);
        }else return (lb.val<root.val&&root.val<rb.val)&&isValid(root.left,lb,root)&&isValid(root.right,root,rb);
        return false;
    }
    */
}
