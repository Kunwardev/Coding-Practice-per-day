/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author DEV
 */
public class BFS {
    
    private static void function(Graph g, int s){
        boolean[] visited = new boolean[g.V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        while(!q.isEmpty()){
            //System.out.println("Q"+q);
            int t = q.poll();
            System.out.print(t+" ");
            ArrayList<Integer> nodes = g.vertices[t].adj;
            //System.out.println("N"+nodes);
            Iterator<Integer> i = nodes.listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        function(g, 1);
    }
    
}
