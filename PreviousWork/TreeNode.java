/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author DEV
 */
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public void printInOrder(TreeNode root){
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.data+" ");
            printInOrder(root.right);
        }
    }
}
