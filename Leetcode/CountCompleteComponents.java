package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CountCompleteComponents {
    
    private static void dfs(HashMap<Integer, ArrayList<Integer>> adjList, int i, boolean[] visited, HashSet<Integer> set){
        ArrayList<Integer> edges = adjList.get(i);
        visited[i] = true;
        set.add(i);
        for(int j=0;j<edges.size();j++){
            if(!visited[edges.get(j)]){
                dfs(adjList, edges.get(j), visited, set);
            }
        }
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        int count = 0;
        for(int i=0;i<edges.length;i++){
            adjList.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            adjList.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                System.out.println("I"+i);
                dfs(adjList, i, visited, set);
            }
            if(adjList.get(i).size() == set.size()-1){
                System.out.println(i);
                count++;
                set.clear();
            }
        }
        System.out.println(adjList);
        return count;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1},{0,2},{1,2},{3,4}};
        int test = countCompleteComponents(5, edges);
        System.out.println("Number of Connected Components: "+test);
    }

}
