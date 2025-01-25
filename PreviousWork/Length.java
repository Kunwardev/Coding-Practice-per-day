/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.LinkedList;

/**
 *
 * @author DEV
 */
public class Length {
    
    // Iteration
    private static int length(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    //Recursion
    private static int lengthR(Node head){
        int count = 0;
        return lengthRHelper(head, count);
    }
    
    private static int lengthRHelper(Node head, int count) {
        if(head == null)
            return count;
        return lengthRHelper(head.next, count+1);
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        System.out.println(length(head));
        System.out.println(lengthR(head));
    }
    
}
