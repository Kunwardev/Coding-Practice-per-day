/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Tree;

/**
 *
 * @author kunwar
 */
public class TreeToDoubleLinkedList {
    
    private static TreeNode function(TreeNode root){
        if(root == null)
            return null;
        root = functionUtil(root);
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    private static TreeNode functionUtil(TreeNode root) {
        if(root == null)
            return root;
        if(root.left != null){
            TreeNode left = functionUtil(root.left);
            for(;left.right != null; left=left.right);
            left.right = root;
            root.left = left;
        }
        if(root.right != null){
            TreeNode right = functionUtil(root.right);
            for(;right.left != null; right = right.left);
            right.left = root;
            root.right = right;
        }
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(20);
        root.right.right = new TreeNode(28);
        root = function(root);
        while(root.right != null){
            System.out.print(root.data+" ");
            root = root.right;
        }
        System.out.println();
        while(root.left != null){
            System.out.print(root.data+ " ");
            root = root.left;
        }
        
    }
    
}
