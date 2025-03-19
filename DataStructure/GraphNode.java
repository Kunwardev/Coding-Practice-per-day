package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    
    public int V;
    public List<List<Integer>> list;
    
    public GraphNode(int v){
        this.V = v;
        this.list = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            this.list.add(new ArrayList<>());
        }
    }

    public void addEdge(int i, int j) {
        this.list.get(i).add(j);
        this.list.get(j).add(i);
    }

    public void addEdgeSingle(int i, int j){
        this.list.get(i).add(j);
    }

}
