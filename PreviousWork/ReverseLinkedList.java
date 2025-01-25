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
public class Reverse {
    
    private static Node function(Node head){
        Node prev = null, current = head, next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node sample = head;
        while(sample != null){
            System.out.print(sample.data+" ");
            sample = sample.next;
        }
        System.out.println("");
        head = function(head);
        
        sample = head;
        while(sample != null){
            System.out.print(sample.data+" ");
            sample = sample.next;
        }
    }
    
}
