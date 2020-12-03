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
 * @author DEV
 */
public class ZigZagTraversal {
    
    private static void function(TreeNode root){
        boolean leftToRight = false;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.offer(root);
        while(!currentLevel.isEmpty()){
            TreeNode dummy = currentLevel.poll();
            System.out.print(dummy.data + " ");
            if(leftToRight){
                if(dummy.right != null){
                    nextLevel.offer(dummy.right);
                }
                if(dummy.left != null){
                    nextLevel.offer(dummy.left);
                }
            } else{
                if(dummy.left != null){
                    nextLevel.offer(dummy.left);
                }
                if(dummy.right != null){
                    nextLevel.offer(dummy.right);
                }
            }
            if(currentLevel.isEmpty()){
                Queue<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                leftToRight = !leftToRight;
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        function(root);
        
    }
    
    
}
