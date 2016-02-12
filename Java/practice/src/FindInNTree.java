/**
 * Created by guangzhouzeng on 2/12/16.
 */
import PrintOut.PrintList;

import java.util.*;
public class FindInNTree {
    public static List<Integer> findAllNodes(int[][] arrs, int n, int target){
        if(n == 0) return new ArrayList<>();
        ArrayList<HashSet<Integer>> tree = new ArrayList<>();

        for(int i = 0; i < n; i++){
            tree.add(new HashSet<Integer>());
        }
        for(int[] arr: arrs){
            tree.get(arr[0]).add(arr[1]);
        }

        List<Integer> res = new ArrayList<>();
        getAllNodes(tree, target, 0, false, res);
        return res;
    }

    private static void getAllNodes(ArrayList<HashSet<Integer>> tree, int target, int node, boolean flag, List<Integer> res){
        if(node == target) flag = true;
        if(flag) res.add(node);
        for(int child: tree.get(node)){
            getAllNodes(tree, target, child, flag, res);
        }
    }

    public static List<Integer> findAllNodes2(int[][] arrs, int n, int target){
        if(n == 0) return new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();

        for(int[] arr: arrs){
            HashSet<Integer> children;
            if(!tree.containsKey(arr[0])){
                children = new HashSet<Integer>();
            }else{
                children = tree.get(arr[0]);
            }
            children.add(arr[1]);
            tree.put(arr[0], children);
            if(!tree.containsKey(arr[1])) tree.put(arr[1], new HashSet<Integer>());
        }
        int root = findRoot(tree);
        List<Integer> res = new ArrayList<>();
        getAllNodes2(tree, target, root, false, res);
        return res;
    }

    private static int findRoot(HashMap<Integer, HashSet<Integer>> tree){
        HashSet<Integer> nodes = new HashSet<>();
        for(Integer key: tree.keySet()){
            nodes.add(key);
        }
        for(Integer key: tree.keySet()){
            for(Integer node: tree.get(key)){
                if(nodes.contains(node)) nodes.remove(node);
            }
        }
        return nodes.iterator().next();
    }

    private static void getAllNodes2(HashMap<Integer, HashSet<Integer>> tree, int target, int node, boolean flag, List<Integer> res){
        if(node == target) flag = true;
        if(flag) res.add(node);
        for(int child: tree.get(node)){
            getAllNodes2(tree, target, child, flag, res);
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1,4},{1,5},{2,6},{0,1},{0,2},{0,3}};
        PrintList.printListInt(findAllNodes(arr, 7, 0));
        PrintList.printListInt(findAllNodes2(arr, 7, 0));
    }
}
