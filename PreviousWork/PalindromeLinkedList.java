/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.LinkedList;

import java.util.Stack;

/**
 *
 * @author DEV
 */
public class Palindrome {
    
    private static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    private static boolean functionStack(Node head){
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        while(head != null){
            if(head.data != st.pop())
                return false;
            head = head.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        
        System.out.println(functionStack(head));
        //isPalindrome(head);
    }
    
}
