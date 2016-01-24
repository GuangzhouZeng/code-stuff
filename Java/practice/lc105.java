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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder,0, inorder.length-1);
    }
    private TreeNode build(int[] preorder, int pstart, int pend,
                            int[] inorder, int istart, int iend){
        if(pstart>pend||istart>iend) return null;
        
        TreeNode root = new TreeNode(preorder[pstart]);
        
        int pos = findPos(inorder, istart, iend, root.val); //get position of the root in the inorder array.
        
        root.left =  build(preorder, pstart+1, pos-istart+pstart,inorder,istart,pos-1);
        root.right = build(preorder, pos-istart+pstart+1,pend, inorder,pos+1, iend);
        return root;
    }
    
    private int findPos(int[] inorder, int start, int end, int val){
        for(int i=start;i<=end;i++){
            if(inorder[i]==val) return i;
        }
        return -1;
    }
}