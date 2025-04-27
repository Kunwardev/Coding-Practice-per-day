package April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import DataStructure.GraphNode;

public class Dijkstra {
    
    public int[] dijkstra(int V, int[][] edges, int src){
        // Creating a weighted Graph
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];
            for(int[] neighbor: graph.get(currentNode)){
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currentDist + weight;
                if(newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    pq.offer(new int[] {newDist, nextNode});
                }
            }
        }
        return dist;
    }

}
