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
public class ReverseClone {
    
    private static Node reveseClone(Node head){
        Node clone = null;
        while(head != null){
            Node n = new Node(head.data);
            n.next = clone;
            clone = n;
            head = head.next;
        }
        return clone;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        Node clone = reveseClone(head);
        while(clone != null){
            System.out.print(clone.data + " ");
            clone = clone.next;
        }
    }
    
}
