package May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import DataStructure.TreeNode;

public class BurningTree {
    
    // Using Queue instead of Recursion
    private static TreeNode fetchingParentsOfNode(TreeNode root, int target, HashMap<TreeNode, TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode targetNode = null;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.data == target)
                targetNode = temp;
            if(temp.left != null){
                parentMap.put(temp.left, temp);
                queue.offer(temp.left);
            }
            if(temp.right != null){
                parentMap.put(temp.right, temp);
                queue.offer(temp.right);
            }
        }
        return targetNode;
    }

    public static int minTime(TreeNode root, int target){
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = fetchingParentsOfNode(root, target, parentMap);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.add(targetNode);
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean burned = false;
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left != null && visited.add(temp.left)){
                    queue.offer(temp.left);
                    burned = true;
                }
                if(temp.right != null && visited.add(temp.right)){
                    queue.offer(temp.right);
                    burned = true;
                }
                TreeNode parent = parentMap.get(temp);
                if(parent != null && visited.add(parent)){
                    queue.offer(parent);
                    burned = true;
                }
            }
            if(burned)
                time++;
        }
        return time;
    }

}
