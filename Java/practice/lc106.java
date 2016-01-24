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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    private TreeNode build(int[] inorder, int istart, int iend,
                        int[] postorder, int pstart, int pend){
        if(pstart>pend) return null;
        
        TreeNode root = new TreeNode(postorder[pend]);
        
        int pos = findPos(inorder, istart, iend, root.val);
        
        root.left = build(inorder, istart, pos-1, postorder, pstart, pos-istart+pstart-1);
        root.right = build(inorder, pos+1,iend, postorder, pos-istart+pstart, pend-1);
        return root;
    }
    
    private int findPos(int[] inorder, int start, int end, int val){
        for(int i=start;i<=end;i++){
            if(inorder[i]==val) return i;
        }
        return -1;
    }
}