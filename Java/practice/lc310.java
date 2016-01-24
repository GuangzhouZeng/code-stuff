public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Collections.singletonList(0);
        List<Integer> res = new ArrayList<>();
        List<Set<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++) graph.add(new HashSet<>()); //initialize the graph
        
        for(int[] edge: edges){  //construct the graph
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>(); //construct the leaves
        for(int i=0;i<n;i++){
            if(graph.get(i).size()==1) leaves.add(i); //leaves store the leaf node tag 
        }
        
        while(n>2){
            n-=leaves.size();
            List<Integer> newleaves = new ArrayList<>(); 
            for(int leaf: leaves){ //traverse the leaves
                Set<Integer> node = graph.get(leaf);
                int adj=node.iterator().next();
                graph.get(adj).remove(leaf);
                if(graph.get(adj).size()==1) newleaves.add(adj); //construct the new leaves
            }
            leaves = newleaves;
        }
        return leaves;
        
        
    }
}