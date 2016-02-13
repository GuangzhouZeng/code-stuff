/**
 * Created by guangzhouzeng on 2/13/16.
 */
import PrintOut.PrintList;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
public class GetMaxInPath {
    public static List<Integer>  getMax(TreeNode root){
        List<Integer> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();

        helper(root, curPath, res);
        return res;
    }
    public static List<Integer>  getMaxImprove(TreeNode root){
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> curPath = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        helper(root, curPath, res);
        return res;
    }

    private static void helper(TreeNode root, List<Integer> curPath, List<Integer> res){
        if(root == null) return;
        curPath.add(root.val);
        if(root.left == null && root.right == null){
            int max = 0;
            for(int num: curPath){
                max = num > max ? num : max;
            }
            res.add(max);
           // curPath.remove(curPath.size() - 1);//remember to remove the leaf node's value
           // return;
        }
        if(root.left != null) helper(root.left, curPath, res);
        if(root.right != null) helper(root.right, curPath, res);
        curPath.remove(curPath.size() - 1);
    }

    private static void helper(TreeNode root, PriorityQueue<Integer> curPath, List<Integer> res){
        if(root == null) return;
        curPath.add(root.val);

        if(root.left == null && root.right == null){
            res.add(curPath.peek());
        }

        if(root.left != null) helper(root.left, curPath, res);
        if(root.right != null) helper(root.right, curPath, res);

        curPath.remove(root.val);
    }

    public static void main(String[] args){
        Tree tree = new Tree(new Object[]{1,2,3,10,5,6,7,8});
        tree.printTreeInOrder(tree.root);
        System.out.println();
        tree.printTreePreOrder(tree.root);
        System.out.println();

        PrintList.printListInt(getMax(tree.root));
        PrintList.printListInt(getMaxImprove(tree.root));
    }

}
