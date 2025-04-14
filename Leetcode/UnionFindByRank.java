package Leetcode;

public class UnionFindByRank {
    
    int[] parent, rank;

    public UnionFindByRank(int V){
        parent = new int[V];
        rank = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int findGroups(int V, int[][] edges){
        int countGroups = 0;
        for(int i=0;i<edges.length;i++){
            this.union(edges[i][0], edges[i][1]);
        }
        for(int i=0;i<V;i++){
            if(parent[i] == i)
                countGroups++;
        }
        return countGroups;
    }

    private int find(int u){
        if(parent[u] == u)
            return u;
        return find(parent[u]);
    }

    private void union(int u, int v){
        int uRoot = find(u);
        int vRoot = find(v);
        
        if(rank[uRoot] < rank[vRoot]){
            parent[uRoot] = vRoot;
        }else if(rank[vRoot] < rank[uRoot]){
            parent[vRoot] = uRoot;
        }else{
            parent[vRoot] = uRoot;
            rank[vRoot]++;
        }
    }

    public static void main(String[] args) {
        testFindGroupsSingleGroup();
        testFindGroupsMultipleGroups();
        testFindGroupsNoEdges();
        testFindGroupsAllDisconnected();
        testFindGroupsCycle();
    }

    static void testFindGroupsSingleGroup() {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        UnionFindByRank uf = new UnionFindByRank(V);
        int result = uf.findGroups(V, edges);
        assert result == 1 : "Test failed: All nodes are connected, so there should be 1 group.";
        System.out.println("testFindGroupsSingleGroup passed.");
    }

    static void testFindGroupsMultipleGroups() {
        int V = 6;
        int[][] edges = {{0, 1}, {2, 3}, {4, 5}};
        UnionFindByRank uf = new UnionFindByRank(V);
        int result = uf.findGroups(V, edges);
        assert result == 3 : "Test failed: There are 3 disconnected groups.";
        System.out.println("testFindGroupsMultipleGroups passed.");
    }

    static void testFindGroupsNoEdges() {
        int V = 4;
        int[][] edges = {};
        UnionFindByRank uf = new UnionFindByRank(V);
        int result = uf.findGroups(V, edges);
        assert result == 4 : "Test failed: No edges mean each node is its own group.";
        System.out.println("testFindGroupsNoEdges passed.");
    }

    static void testFindGroupsAllDisconnected() {
        int V = 3;
        int[][] edges = {{0, 1}};
        UnionFindByRank uf = new UnionFindByRank(V);
        int result = uf.findGroups(V, edges);
        assert result == 2 : "Test failed: One edge connects two nodes, leaving one node disconnected.";
        System.out.println("testFindGroupsAllDisconnected passed.");
    }

    static void testFindGroupsCycle() {
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        UnionFindByRank uf = new UnionFindByRank(V);
        int result = uf.findGroups(V, edges);
        assert result == 1 : "Test failed: A cycle still forms a single connected group.";
        System.out.println("testFindGroupsCycle passed.");
    }
}
