/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kunwar
 */
public class DetectCycleinDirectedGraph {
    
    private static boolean function(Graph g){
        boolean[] visited = new boolean[g.V];
        boolean[] recordVertex = new boolean[g.V];
        for(int i=0;i<g.V;i++){
            if(functionUtil(g, i, visited, recordVertex)){
                return true;
            }
        }
        return false;
    }

    private static boolean functionUtil(Graph g, int i, boolean[] visited, boolean[] recordVertex) {
        if(recordVertex[i])
            return true;
        if(visited[i])
            return false;
        visited[i] = true;
        recordVertex[i] = true;
        
        List<Integer> children = g.vertices[i].adj;
        for(Integer c: children){
            if(functionUtil(g, c, visited, recordVertex))
                return true;
        }
        recordVertex[i] = false;
        return false;
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
        System.out.println(function(graph));
    }
    
}
