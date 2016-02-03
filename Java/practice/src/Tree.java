import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangzhouzeng on 2/2/16.
 */
public class Tree {
    TreeNode root;
    public Tree(Object[] arr){
        Queue<TreeNode> queue = new LinkedList<>();
        if(arr.length == 0 || arr[0] == null) return;
        int idx = 0;
        root = new TreeNode((int)arr[idx++]);
        queue.add(root);
        while(!queue.isEmpty()&&idx<arr.length){
            TreeNode temp = queue.poll();
            if(arr[idx] != null) temp.left = new TreeNode((int)arr[idx]);
            idx++;
            if(arr[idx] != null) temp.right = new TreeNode((int)arr[idx]);
            idx++;
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null) queue.offer(temp.right);
        }
    }

    public void printTreePreOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+",");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }
    public void printTreeInOrder(TreeNode root){
        if(root == null) return;
        printTreeInOrder(root.left);
        System.out.print(root.val + ",");
        printTreeInOrder(root.right);
    }
}
