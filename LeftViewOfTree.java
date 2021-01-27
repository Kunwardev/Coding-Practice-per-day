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
public class LeftViewOfTree {
    
    static int max_level = 0;
    
    private static void function(TreeNode root){
        functionHelper(root, 1);
    }

    private static void functionHelper(TreeNode root, int i) {
        if(root == null)
            return;
        if(max_level < i){
            System.out.print(root.data + " ");
            max_level = i;
        }
        functionHelper(root.left, i+1);
        functionHelper(root.right, i+1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(5);
        function(root);
    }
    
}
