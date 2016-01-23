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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end){ 
            res.add(null);
        }
        
        for(int i=start;i<=end;i++){
            List<TreeNode> lefts = generateTrees(start, i-1);
            List<TreeNode> rights = generateTrees(i+1,end);
            
            for(TreeNode left: lefts){
                for(TreeNode right: rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}