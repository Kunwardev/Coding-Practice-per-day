/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author kunwar
 */
public class LevelOrderTraversal {
    
    
    // Recursion
    private static void function(TreeNode root){
        int height = getHeight(root);
        for(int i=1; i<=height; i++){
            functionHelper(root, i);
        }
    }

    private static int getHeight(TreeNode root) {
        TreeNode head = root;
        if(root == null)
            return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        if(lHeight > rHeight)
            return lHeight+1;
        return rHeight+1;
    }

    private static void functionHelper(TreeNode root, int i) {
        if(root == null)
            return;
        if(i == 1)
            System.out.print(root.data+" ");
        else if(i > 1){
            functionHelper(root.left, i-1);
            functionHelper(root.right, i-1);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        function(root);
        System.out.println("------------------------");
        functionQ(root);
    }
    
    // Using Queue
    private static void functionQ(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode pop = queue.poll();
            //System.out.print(pop.data+" ");
            if(pop != null){
                if(pop.left != null)
                    queue.offer(pop.left);
                if(pop.right != null)
                    queue.offer(pop.right);
            }
            
        }
        
    }
    
}
