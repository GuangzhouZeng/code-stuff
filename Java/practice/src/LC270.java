/**
 * Created by guangzhouzeng on 2/2/16.
 */
/*
Problem Description:

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */


public class LC270{
    public static TreeNode findClosest(TreeNode root, float target){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        if(root.right != null && Math.abs(root.val - target) > Math.abs(root.right.val - target)){
            return findClosest(root.right, target);
        }
        if(root.left != null && Math.abs(root.val - target) > Math.abs(root.left.val - target)){
            return findClosest(root.left, target);
        }
        return root;
    }
    public static int findClosest2(TreeNode root, float target){
        int a = root.val;
        TreeNode child = a < target ? root.right : root.left;
        if(child == null) return a;
        int b = findClosest2(child, target);
        return Math.abs(a - target) > Math.abs(b - target) ? b : a;
    }

    public static void main(String[] args){
        Object[] arr = {10,8,13,4,null,12,16};
        Tree tree = new Tree(arr);
        tree.printTreePreOrder(tree.root);
        System.out.println();
        tree.printTreeInOrder(tree.root);
        System.out.println();
        for(int i = 4; i < 17; i++) {
            System.out.println(i+" \t"+findClosest(tree.root, i).val+" \t"+findClosest2(tree.root, i));
        }

    }
}
