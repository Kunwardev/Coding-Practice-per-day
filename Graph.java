/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Graph;

import java.util.ArrayList;

/**
 *
 * @author DEV
 */
public class Graph {
    
    int V;
    Node[] vertices;
    
    class Node{
        int data;
        ArrayList<Integer> adj;
        
        public Node(int data){
            this.data = data;
            this.adj = new ArrayList<>();
        }
        
    }
    
    public Graph(int V){
        this.V = V;
        this.vertices  = new Node[V];
        for(int i = 0; i < V; i++){
            vertices[i] = new Node(i);
        }
        
    }
    
    public void addEdge(int u, int v){
        this.vertices[u].adj.add(v);
    }
    
    public void print(){
        for(int i=0;i<this.V; i++){
            System.out.print(i+" -> ");
            for(int j=0;j<this.vertices[i].adj.size();j++){
                System.out.print(this.vertices[i].adj.get(j)+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.print();
        
        
    }
    
}
