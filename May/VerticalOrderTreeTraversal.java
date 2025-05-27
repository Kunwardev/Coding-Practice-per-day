package May;

import DataStructure.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TPair
{
    TreeNode root;
    int level;

    public TPair(TreeNode root, int level){
        this.root = root;
        this.level = level;
    }
}


public class VerticalOrderTreeTraversal
{
    private HashMap<Integer, ArrayList<Integer>> function(TreeNode root){
        Queue<TPair> queue = new LinkedList<>();
        queue.add(new TPair(root, 0));
        HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();
        while(!queue.isEmpty()){
            TPair temp = queue.poll();
            ArrayList<Integer> llist = result.getOrDefault(temp.level, new ArrayList<>());
            llist.add(temp.root.data);
            result.put(temp.level, llist);
            if(temp.root.left != null){
                queue.offer(new TPair(temp.root.left, temp.level-1));
            }
            if(temp.root.right != null){
                queue.offer(new TPair(temp.root.right, temp.level+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Construct the following binary tree:
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4   5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        VerticalOrderTreeTraversal traversal = new VerticalOrderTreeTraversal();
        HashMap<Integer, ArrayList<Integer>> result = traversal.function(root);

        // Print the vertical order traversal
        for (Integer key : result.keySet()) {
            System.out.println("Level " + key + ": " + result.get(key));
        }

        // Example assertion (manual check)
        // Level -2: [4]
        // Level -1: [2]
        // Level 0: [1, 5, 6]
        // Level 1: [3]
        // Level 2: [7]
    }
}