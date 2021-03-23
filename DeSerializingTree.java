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
public class DeSerializingTree {
    
    static final char marker = '$';
    static int index = 0;
    private static TreeNode function(String s){
        TreeNode root;
        if(index >= s.length() || s.charAt(index) == marker){
            return null;
        }
        root = new TreeNode((s.charAt(index)-'0'));
        index++;
        root.left = function(s);
        index++;
        root.right = function(s);
        return root;
    }
    
    public static void main(String[] args) {
        String s = "12$$3$$";
        TreeNode root = function(s);
        System.out.println(root.data + " " + root.left.data + " " + root.right.data);
    }
    
}
