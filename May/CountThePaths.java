package May;

import java.util.ArrayList;
import java.util.Arrays;

public class CountThePaths {
    
    public int countPaths(int[][] edges, int V, int src, int dest) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++)
            graph.add(new ArrayList<Integer>());
        
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
        }
        int[] dp = new int[V];
        Arrays.fill(dp, -1);
        return dfs(graph, dp, src, dest);

    }

    private int dfs(ArrayList<ArrayList<Integer>> graph, int[] dp, int src, int dest) {
        if(src == dest)
            return 1;
        if(dp[src] != -1)
            return dp[src];
        int count = 0;
        for(int v: graph.get(src)){
            count+=dfs(graph, dp, v, dest);
        }
        dp[src] = count;
        return count;
    }

}
