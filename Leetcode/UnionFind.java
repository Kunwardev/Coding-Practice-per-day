package Leetcode;

import DataStructure.GraphNode;

public class UnionFind {
    
    private static int findGroups(int V, int[][] edges){
        int countGroups = 0;
        int[] parents = new int[V];
        for(int i=0;i<V;i++){
            parents[i] = i;
        }
        for(int i=0;i<edges.length;i++){
            union(edges[i][0], edges[i][1], parents);
        }
        for(int i=0;i<V;i++){
            if(parents[i] == i)
                countGroups++;
        }
        return countGroups;
    }

    private static void union(int i, int j, int[] parents) {
        int parentI = find(i, parents);
        int parentJ = find(j, parents);
        parents[parentI] = parentJ;
    }

    private static int find(int j, int[] parents) {
        if(parents[j] == j)
            return j;
        return find(parents[j], parents);
    }

    public static void main(String[] args) {
        // Test case 1: No edges, all nodes are separate groups
        int V1 = 5;
        int[][] edges1 = {};
        int expectedOutput1 = 5;
        int actualOutput1 = UnionFind.findGroups(V1, edges1);
        System.out.println("Test case 1: " + (expectedOutput1 == actualOutput1 ? "Passed" : "Failed"));

        // Test case 2: All nodes connected in a single group
        int V2 = 4;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        int expectedOutput2 = 1;
        int actualOutput2 = UnionFind.findGroups(V2, edges2);
        System.out.println("Test case 2: " + (expectedOutput2 == actualOutput2 ? "Passed" : "Failed"));

        // Test case 3: Two separate groups
        int V3 = 6;
        int[][] edges3 = {{0, 1}, {1, 2}, {3, 4}};
        int expectedOutput3 = 3;
        int actualOutput3 = UnionFind.findGroups(V3, edges3);
        System.out.println("Test case 3: " + (expectedOutput3 == actualOutput3 ? "Passed" : "Failed"));

        // Test case 4: Single node graph
        int V4 = 1;
        int[][] edges4 = {};
        int expectedOutput4 = 1;
        int actualOutput4 = UnionFind.findGroups(V4, edges4);
        System.out.println("Test case 4: " + (expectedOutput4 == actualOutput4 ? "Passed" : "Failed"));

        // Test case 5: Multiple disconnected nodes
        int V5 = 3;
        int[][] edges5 = {};
        int expectedOutput5 = 3;
        int actualOutput5 = UnionFind.findGroups(V5, edges5);
        System.out.println("Test case 5: " + (expectedOutput5 == actualOutput5 ? "Passed" : "Failed"));
    }

}
