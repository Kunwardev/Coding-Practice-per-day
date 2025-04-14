package Leetcode;

import DataStructure.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerialization {

    // Serialize the tree to a string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.data).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Deserialize the string back to a tree
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);
        return root;
    }

    public static void main(String[] args) {
        TreeSerialization ts = new TreeSerialization();

        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Serialize the tree
        String serialized = ts.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        // Deserialize the string back to a tree
        TreeNode deserializedRoot = ts.deserialize(serialized);
        System.out.println("Deserialized tree (pre-order traversal):");
        ts.printPreOrder(deserializedRoot);
    }

    // Helper function to print the tree in pre-order traversal
    private void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}