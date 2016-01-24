/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    //private Map<Integer, UndirectedGraphNode> map = new HashMap<>(); //avoid inifinity loop
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        ////dfs
        /*if(node==null) return null;
        if(map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label,newNode);
        
        for(UndirectedGraphNode neighbor: node.neighbors){
            UndirectedGraphNode newNeibor = cloneGraph(neighbor);
            newNode.neighbors.add(newNeibor);
        }
        return newNode;
        */
        
        ////BFS
        if(node==null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        map.put(node.label,newnode);
        
        q.offer(node);
        
        while(!q.isEmpty()){
            UndirectedGraphNode temp = q.poll();
            for(UndirectedGraphNode neibor: temp.neighbors){
                if(!map.containsKey(neibor.label)){
                    map.put(neibor.label,new UndirectedGraphNode(neibor.label));
                    q.offer(neibor);
                }
                map.get(temp.label).neighbors.add(map.get(neibor.label));
            }
            
        }
        return newnode;
        
    }
}