package May;

import java.util.ArrayList;
import java.util.HashMap;

import DataStructure.TreeNode;

public class ChangingTreeToUndirectedGraph {
    
    private void functionUtil(TreeNode root, TreeNode parent, HashMap<TreeNode, ArrayList<TreeNode>> hMap)
    {
        if(root == null)
            return ;
        if(!hMap.containsKey(root)){
            hMap.put(root, new ArrayList<TreeNode>());
            if(parent != null){
                hMap.get(root).add(parent);
                hMap.get(parent).add(root);
            }
            functionUtil(root.left, root, hMap);
            functionUtil(root.right, root, hMap);
        }
    }

    private HashMap<TreeNode, ArrayList<TreeNode>> function(TreeNode root)
    {
        HashMap<TreeNode, ArrayList<TreeNode>> hMap = new HashMap<>();
        functionUtil(root, null, hMap);
        return hMap;
    }

    public static void main(String[] args) {
        // Test 1: Simple Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        ChangingTreeToUndirectedGraph changer = new ChangingTreeToUndirectedGraph();
        HashMap<TreeNode, ArrayList<TreeNode>> graph1 = changer.function(root1);

        System.out.println("Test 1: Simple Tree");
        System.out.println("Graph size: " + graph1.size());
        System.out.println("Root connections: " + graph1.get(root1));
        System.out.println("Left connections: " + graph1.get(root1.left));
        System.out.println("Right connections: " + graph1.get(root1.right));
        System.out.println();

        // Test 2: Single Node
        TreeNode root2 = new TreeNode(10);
        HashMap<TreeNode, ArrayList<TreeNode>> graph2 = changer.function(root2);

        System.out.println("Test 2: Single Node");
        System.out.println("Graph size: " + graph2.size());
        System.out.println("Root connections: " + graph2.get(root2));
        System.out.println();

        // Test 3: Null Root
        HashMap<TreeNode, ArrayList<TreeNode>> graph3 = changer.function(null);

        System.out.println("Test 3: Null Root");
        System.out.println("Graph size: " + graph3.size());
    }

}
