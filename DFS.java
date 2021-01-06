/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Graph;

import java.util.Iterator;

/**
 *
 * @author DEV
 */
public class DFS {
    
    private static void function(Graph g, int i){
        boolean[] visited = new boolean[g.V];
        functionUtil(g, i, visited);
    }

    private static void functionUtil(Graph g, int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i+ " ");
        Iterator<Integer> p = g.vertices[i].adj.listIterator();
        while(p.hasNext()){
            int x = p.next();
            if(!visited[x])
                functionUtil(g, x, visited);
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        function(g, 2);
    }
    
}
