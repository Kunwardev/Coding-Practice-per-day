package Leetcode;

import java.util.HashMap;

public class MaxCycleInGraph {
    private static int function(int[] edges){
        int[] answer = new int[]{-1};
        int length = edges.length;
        boolean[] visited = new boolean[length];
        for(int i=0;i<length;i++){
            if(!visited[i]){
                HashMap<Integer, Integer> hMap = new HashMap<>();
                hMap.put(i, 1);
                dfs(edges, i, hMap, answer, visited);
                            }
                        }
                
        return answer[0];
    }
                
    private static void dfs(int[] edges, int i, HashMap<Integer, Integer> hMap, int[] answer, boolean[] visited) {
        visited[i] = true;
        int neighbor = edges[i];
        if(neighbor != -1 && !visited[neighbor]){
            hMap.put(neighbor, hMap.get(i)+1);
            dfs(edges, neighbor, hMap, answer, visited);
        }
        else if(neighbor != -1 && hMap.containsKey(neighbor)){
            answer[0] = Math.max(answer[0], hMap.get(i)-hMap.get(neighbor)+1);
        }
    }

    public static void main(String[] args) {
        int[] edges = {1, 2, 0, 4, 5, 3, 6, 7, 8, 6};
        int result = function(edges);
        System.out.println("The length of the longest cycle is: " + result);
    }
}
