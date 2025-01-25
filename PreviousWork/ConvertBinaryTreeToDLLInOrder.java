/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Misc;

/**
 *
 * @author DEV
 */

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ConvertBinaryTreeToDLLInOrder {
    
    static Node head;
    
    private static void function(Node root){
        if(root == null)
            return;
        function(root.right);
        root.right = head;
        if(head != null){
            head.left = root;
        }
        head = root;
        function(root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        function(root);
        System.out.println("InOrder: ");
        Node traverse = head;
        while(traverse != null)
        {
            System.out.print(traverse.data+" ");
            traverse = traverse.right;
        }
    }
    
    
}
