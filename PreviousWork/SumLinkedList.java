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
public class SumLinkedList {
    
    // Head is having the first position
    private static Node function(Node l1, Node l2){
        Node result = new Node(0);
        Node final_result = result;
        int carry = 0, sum = 0;
        while(l1 != null || l2 != null){
            sum = carry + (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0);
            carry = sum / 10;
            sum = sum % 10;
            result.next = new Node(sum);
            result = result.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            result.next = new Node(carry);
        }
        return final_result.next;
    }
    
    
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        Node l2 = new Node(9);
        l2.next = new Node(8);
        Node result = function(l1, l2);
        while(result != null){
            System.out.print(result.data + " ");
            result = result.next;
        }
        
    }
    
}
