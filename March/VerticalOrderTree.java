package March;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import DataStructure.TreeNode;

class LevelTreeNode{
    TreeNode root;
    int level;

    public LevelTreeNode(TreeNode root, int level){
        this.level = level;
        this.root = root;
    }
}

public class VerticalOrderTree {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int level = 0;
        Queue<LevelTreeNode> queueTraversal = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        queueTraversal.add(new LevelTreeNode(root, level));
        while(!queueTraversal.isEmpty()){
            LevelTreeNode temp = queueTraversal.poll();
            List<Integer> tempL = map.getOrDefault(temp.level, new ArrayList<>());
            if(temp.root == null)
                continue;
            tempL.add(temp.root.data);
            map.put(temp.level, tempL);
            System.out.println(map);
            if(temp.root.left != null){
                queueTraversal.add(new LevelTreeNode(temp.root.left, temp.level-1));
            }
            if(temp.root.right != null){
                queueTraversal.add(new LevelTreeNode(temp.root.right, temp.level+1));
            }
        }
        List<List<Integer>> list = new ArrayList<>(); 
        for(Map.Entry<Integer,List<Integer>> mapEntry: map.entrySet()){
            list.add(mapEntry.getValue());
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        VerticalOrderTree verticalOrderTree = new VerticalOrderTree();
        List<List<Integer>> result = verticalOrderTree.verticalOrder(root);
        System.out.println(result);

                    
    }
    
}
