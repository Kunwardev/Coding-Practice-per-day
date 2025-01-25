/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Tree;

import java.util.Stack;

/**
 *
 * @author kunwar
 */
public class InOrderWithoutRecursion {
    
    private static void function(TreeNode root){
        if(root == null)
            return;
         Stack<TreeNode> st = new Stack<>();
         TreeNode curr = root;
         while(curr != null || st.size() > 0){
             while(curr != null){
                 st.push(curr);
                 curr = curr.left;
             }
             curr = st.pop();
             System.out.print(curr.data+" ");
             curr = curr.right;
         }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        function(root);
    }
    
}
