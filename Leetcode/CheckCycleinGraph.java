package Leetcode;

import DataStructure.GraphNode;

public class CheckCycleinGraph {
    
    private static void dfs(GraphNode g, int[] color, boolean[] cycle, int index){
        color[index] = 1;
        for(int i: g.list.get(index)){
            if(color[i] == 1){
                System.out.println(index+" "+i);
                cycle[0] = true;
                return;
            } else if(color[i] == 0)
                dfs(g, color, cycle, i);
        }
        color[index] = 2;
    }

    private static boolean checkCycle(GraphNode g){
        int[] color = new int[g.V];
        boolean[] cycle = {false};
        for(int i=0;i<g.V;i++){
            if(color[i] == 0)
                dfs(g, color, cycle, i);
        }
        return cycle[0];
    }

    public static void main(String[] args) {
        // Create a graph with a cycle
        GraphNode graphWithCycle = new GraphNode(4);
        graphWithCycle.addEdgeSingle(0, 1);
        graphWithCycle.addEdgeSingle(1, 2);
        graphWithCycle.addEdgeSingle(2, 0);
        graphWithCycle.addEdgeSingle(2, 3);
        System.out.println(checkCycle(graphWithCycle));
        GraphNode graphWithoutCycle = new GraphNode(4);
        graphWithoutCycle.addEdgeSingle(0, 1);
        graphWithoutCycle.addEdgeSingle(1, 2);
        graphWithoutCycle.addEdgeSingle(2, 3);
        System.out.println(checkCycle(graphWithoutCycle));

    }

}
