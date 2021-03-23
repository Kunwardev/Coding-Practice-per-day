/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Graph;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author DEV
 */
public class TopologicalSort {
    
    private static void function(Graph g){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[g.V];
        for(int i=0;i<g.V;i++){
            if(!visited[i])
                functionHelper(g, i, visited, st);
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    private static void functionHelper(Graph g, int i, boolean[] visited, Stack<Integer> st) {
        visited[i] = true;
        Integer j;
        Iterator<Integer> it = g.vertices[i].adj.listIterator();
        while(it.hasNext()){
            j = it.next();
            if(!visited[j])
                functionHelper(g, j, visited, st);
        }
        st.push(i);
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        function(g);
    }
    
}
