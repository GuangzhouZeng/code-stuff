/**
 * Created by guangzhouzeng on 2/5/16.
 */
/*
Problem Description:

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices
are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1]
is the same as [1, 0] and thus will not appear together inedges.

 */
import java.util.*;
public class LC261 {
    public static boolean solution(int n, int[][] edges){
        if(n < 1) return false;
        if(edges == null || edges.length == 0 || edges[0].length == 0){
            if(n == 1) return true;
            else return false;
        }

        List<HashSet<Integer>> nodes = new LinkedList<>();
        for(int i = 0; i < n; i++){
            nodes.add(new HashSet<Integer>());
        }

        for(int[] edge: edges){
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean[] visited = new boolean[n];

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(visited[cur]) return false;
            visited[cur] = true;
            for(int i: nodes.get(cur)){
                queue.add(i);
                nodes.get(i).remove(cur);
            }
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        int n = 5;
        int[][] edges = {{1,2},{2,3},{3,4},{4,0}};
        System.out.println(solution(n, edges));
    }
}
