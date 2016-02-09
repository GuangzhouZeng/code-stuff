/**
 * Created by guangzhouzeng on 2/8/16.
 */
public class DeepestNode {
    static int maxLevel = 0;
    static TreeNode node;

    public static TreeNode getDeepestNode(TreeNode root){
        helper(root, 0);
        return node;
    }
    private static void helper(TreeNode root, int level){
        if(root == null) return;
        if(level > maxLevel){
            node = root;
            maxLevel = level;
        }
        if(root.left != null) helper(root.left, level + 1);
        if(root.right != null) helper(root.right, level + 1);
    }

    public static void main(String[] args){
        Object arr[] = {1,2,3,4,null,null,null,6};
        Tree tree = new Tree(arr);
        tree.printTreePreOrder(tree.root);
        System.out.println();
        tree.printTreeInOrder(tree.root);
        System.out.println();


        TreeNode node = getDeepestNode(tree.root);
        System.out.println(node.val);
    }
}
