package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

import DataStructure.GraphNode;

public class TopologicalSorting {
    // Similar to DFS, but we are using a stack to put the variable in it, so that they can be popped after all the traversal
    private void sort(GraphNode g){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[g.V];
        for(int i=0;i<g.V;i++){
            if(!visited[i]){
                sortUtil(g, i, st, visited);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        System.out.println(res);
    }

    private void sortUtil(GraphNode g, int i, Stack<Integer> st, boolean[] visited){
        visited[i] = true;
        for(int index: g.list.get(i)){
            if(!visited[index])
                sortUtil(g, index, st, visited);
        }
        st.push(i);
    }


    public static void main(String[] args) {
        GraphNode g = new GraphNode(4);
        g.addEdgeSingle(0, 1);
        g.addEdgeSingle(1, 2);
        g.addEdgeSingle(3, 0);
        g.addEdgeSingle(3, 1);
        TopologicalSorting t = new TopologicalSorting();
        t.sort(g);
    }

}
