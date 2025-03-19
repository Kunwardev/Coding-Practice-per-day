package Leetcode;

import DataStructure.GraphNode;

public class DFSGraph {
    
    private void dfs(GraphNode g){
        boolean[] visited = new boolean[g.V];
        for(int i=0;i<g.V;i++){
            if(!visited[i]){
                dfsUtil(g, visited, i);
            }
        }
    }
                
    private void dfsUtil(GraphNode g, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(i+" ");
        for(int index: g.list.get(i)){
            if(!visited[index]){
                dfsUtil(g, visited, index);
            }
        }
    }

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        DFSGraph dfsGraph = new DFSGraph();
        dfsGraph.dfs(graph); 
    }

}
