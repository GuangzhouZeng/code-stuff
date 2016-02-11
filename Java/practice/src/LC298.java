/**
 * Created by guangzhouzeng on 2/8/16.
 */
/*
Problem Description:

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the
tree along the parent-child connections. The longest consecutive path need to be from
parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */

public class LC298 {
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }

    //top - down
    public static int longestConsecutivePath(TreeNode root){
        return helper(root, null, 0);
    }
    private static int helper(TreeNode root, TreeNode parent, int len){
        if(root == null) return len;
        len = parent != null && root.val == parent.val + 1 ? len + 1 : 1;
        return Math.max(len, Math.max(helper(root.left, root, len), helper(root.right, root, len)));
    }

    //bottom - up
    public static int maxLen = 0;
    public static int longestConsecutivePath2(TreeNode root){
        helper2(root);
        return maxLen;
    }

    private static int helper2(TreeNode root){
        if(root == null){
            return 0;
        }
        int maxLeft = helper2(root.left);
        int maxRight = helper2(root.right);

        maxLeft = root.left != null && root.val + 1 == root.left.val ? maxLeft + 1 : 1;
        maxRight = root.right != null && root.val + 1 == root.right.val ? maxRight + 1 : 1;

        maxLen = Math.max(maxLen, Math.max(maxLeft, maxRight));

        return Math.max(maxLeft, maxRight);
    }
}
