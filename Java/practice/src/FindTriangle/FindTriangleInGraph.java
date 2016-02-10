package FindTriangle;

import java.util.*;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class FindTriangleInGraph {
    public static int findTriangle(int n, int[][] arrs){
        List<Set<Integer>> nodes = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            nodes.add(new HashSet<Integer>());
        }

        for(int[] arr: arrs){
            nodes.get(arr[0]).add(arr[1]);
            nodes.get(arr[1]).add(arr[0]);
        }

        Set<List<Integer>> triangleSet = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            dfs(nodes, i, i, cur, triangleSet);
        }

        for(List<Integer> list: triangleSet){
            for(Integer node: list){
                System.out.print(node + " ");
            }
            System.out.println();
        }

        return triangleSet.size();
    }

    private static void dfs(List<Set<Integer>> nodes, int startNode, int curNode,
                            List<Integer> cur, Set<List<Integer>> set){
        if(curNode == startNode && cur.size() == 3){
            ArrayList cur_temp = new ArrayList<>(cur);
            Collections.sort(cur_temp); //use a new ArrayList to sort here
            set.add(cur_temp);
            return;
        }
        if(cur.size() == 3) return;

        if(!cur.contains(curNode)) {
            cur.add(curNode);
            for(int i: nodes.get(curNode)){
                dfs(nodes, startNode, i, cur, set);
            }
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args){
        int[][] arrs = {{0,1},{0,2},{0,3},{1,2},{1,3},{2,3},{3,1},{3,0},{3,2}};
        int[][] arrs1 = {{0,1},{0,3},{1,2},{1,3},{2,3}};
        int[][] arrs2 = {{0,1},{0,2}};

        System.out.println(findTriangle(4, arrs));
        System.out.println(findTriangle(4, arrs1));
    }
}