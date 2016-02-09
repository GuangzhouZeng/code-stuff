/**
 * Created by guangzhouzeng on 2/8/16.
 */
public class SameTree {
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        String str;
        TreeNode(String str){
            this.str = str;
        }
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return t1.str.equals(t2.str) && isSameTree(t1.left, t2.left) && isSameTree(t2.right, t2.right);
    }
}
