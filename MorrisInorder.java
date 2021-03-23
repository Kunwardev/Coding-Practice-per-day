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
public class MorrisInorder {
    
    private static void function(TreeNode root){
        if(root == null)
            return;
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            } else{
                TreeNode predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                } else{
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(6);
        function(root);
    }
    
}