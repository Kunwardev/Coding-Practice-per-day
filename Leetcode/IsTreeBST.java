package Leetcode;

import DataStructure.TreeNode;

public class IsTreeBST {
    
    private static boolean validUtil(TreeNode root, int min, int max){
        if(root == null)
            return true;
        if(root.data < min || root.data > max)
            return false;
        return validUtil(root.left, min, root.data-1) && validUtil(root.right, root.data+1, max);
    }

    private static boolean valid(TreeNode root){
        return validUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        // Valid Tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(valid(root));

        // Invalid Tree
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(valid(root1));
    }

}
