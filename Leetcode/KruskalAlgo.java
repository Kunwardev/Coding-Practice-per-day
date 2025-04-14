package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {
    
    static class Edge{
        int src, dest, weight;
        
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class UnionFind{
        int[] parent, rank;

        UnionFind(int V){
            this.parent = new int[V];
            this.rank = new int[V];
            for(int i=0;i<V;i++)
                parent[i] = i;
        }

        int find(int u){
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // Path compression
            }
            return parent[u];
        }

        boolean union(int u, int v){
            int pU = find(u);
            int pV = find(v);
            if(pU == pV)
                return false; // Cycle Detected;
            if(rank[pU] < rank[pV]){
                parent[pU] = parent[pV];
            }
            else if(rank[pV] < rank[pU]){
                parent[pV] = parent[pU];
            }else{
                parent[pV] = pU;
                rank[pU]++;
            }
            return true;
        }
    }

    public int kruskalMST(int V, List<List<int[]>> adj) {
        // Step 1: Convert adjacency list to edge list
        List<Edge> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (u < v) { // Avoid duplicate edges in undirected graph
                    edges.add(new Edge(u, v, weight));
                }
            }
        }

        // Step 2: Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Step 3: Initialize Union-Find
        UnionFind uf = new UnionFind(V);

        // Step 4: Process edges and build MST
        int mstWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                mstWeight += edge.weight;
                edgesUsed++;
                if (edgesUsed == V - 1) {
                    break; // MST is complete
                }
            }
        }

        return mstWeight;
    }
    public static void main(String[] args) {
        KruskalAlgo kruskal = new KruskalAlgo();

        // Test case 1: Simple graph
        int V1 = 4;
        List<List<int[]>> adj1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) adj1.add(new ArrayList<>());
        adj1.get(0).add(new int[]{1, 1});
        adj1.get(0).add(new int[]{2, 2});
        adj1.get(1).add(new int[]{0, 1});
        adj1.get(1).add(new int[]{2, 3});
        adj1.get(1).add(new int[]{3, 4});
        adj1.get(2).add(new int[]{0, 2});
        adj1.get(2).add(new int[]{1, 3});
        adj1.get(2).add(new int[]{3, 5});
        adj1.get(3).add(new int[]{1, 4});
        adj1.get(3).add(new int[]{2, 5});
        int expected1 = 7; // MST weight
        int result1 = kruskal.kruskalMST(V1, adj1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: Disconnected graph
        int V2 = 3;
        List<List<int[]>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) adj2.add(new ArrayList<>());
        adj2.get(0).add(new int[]{1, 1});
        adj2.get(1).add(new int[]{0, 1});
        int expected2 = 1; // MST weight (only one edge can be included)
        int result2 = kruskal.kruskalMST(V2, adj2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Single node graph
        int V3 = 1;
        List<List<int[]>> adj3 = new ArrayList<>();
        adj3.add(new ArrayList<>());
        int expected3 = 0; // MST weight (no edges)
        int result3 = kruskal.kruskalMST(V3, adj3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));
    }
}
