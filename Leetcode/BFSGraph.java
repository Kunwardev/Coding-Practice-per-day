package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

import DataStructure.GraphNode;

public class BFSGraph {
    
    private static void bfs(GraphNode g, int s){
        boolean[] visited = new boolean[g.V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int index = q.poll();
            System.out.print(index+" ");
            for(int i: g.list.get(index)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(5);
        
        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        
        // Expected output: 0 1 2 3 4
        bfs(graph, 0);
    }

}
