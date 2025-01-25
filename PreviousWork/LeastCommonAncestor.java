/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Tree;

/**
 *
 * @author DEV
 */
public class LeastCommonAncestor {
    
    private static TreeNode function(TreeNode root, int n1, int n2){
        if(root == null)
            return null;
        if(root.data == n1 || root.data == n2){
            return root;
        }
        TreeNode leftSide = function(root.left, n1, n2);
        TreeNode rightSide = function(root.right, n1, n2);
        
        if(leftSide != null && rightSide != null)
            return root;
        
        return (leftSide != null) ? leftSide : rightSide;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(function(root, 4, 5).data);
    }
    
}
