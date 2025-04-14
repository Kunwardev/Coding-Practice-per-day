package Leetcode;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

public class SerializationDeSerialization {
    
    private void serializePreOrder(TreeNode root, ArrayList<Integer> res){
        if(root == null){
            res.add(-1);
            return;
        }
        res.add(root.data);
        serializePreOrder(root.left, res);
        serializePreOrder(root.right, res);
    }

    private TreeNode deserializtionPreOrder(List<Integer> res, int[] index){
        if(res.get(index[0]) == -1)
            return null;
        TreeNode root = new TreeNode(res.get(index[0]));
        index[0]++;
        root.left = deserializtionPreOrder(res, index);
        index[0]++;
        root.right = deserializtionPreOrder(res, index);
        return root;
    }

    public static void main(String[] args) {
        SerializationDeSerialization serializer = new SerializationDeSerialization();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<Integer> result = new ArrayList<>();
        serializer.serializePreOrder(root, result);
        int[] index = {0};
        System.out.println(result);
        TreeNode head = serializer.deserializtionPreOrder(result, index);
        System.out.println(root.data + " " + root.left.data + " " + root.right.data + " " + root.left.left.data + " " + root.left.right.data);
    }

}
