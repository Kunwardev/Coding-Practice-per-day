/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author kunwar
 */
public class SerializingTree {
    
    static final char marker = '$';
    
    private static String serialize(TreeNode root){
        String s = "";
        if(root == null)
            return s+marker;
        String leftSide = serialize(root.left);
        String rightSide = serialize(root.right);
        s = s + root.data + leftSide + rightSide;
        return s;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(serialize(root));
    }
    
}
