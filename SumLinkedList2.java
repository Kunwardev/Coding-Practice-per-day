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
class PartialSum{
    Node sum = null;
    int carry = 0;
}

public class SumLinkedList2 {
    
    // Head is having the last position
    private static Node function(Node l1, Node l2){
        int length_1 = length(l1);
        int length_2 = length(l2);
        Node result;
        if(length_1 == length_2){
            result = AddSameSize(l1, l2);
        } else if(length_1 > length_2){
            l2 = padding(l2, length_1 - length_2);
            result = AddSameSize(l1, l2);
        } else{
            l1 = padding(l1, length_2 - length_1);
            result = AddSameSize(l1, l2);
        }
        return result;
    }
    
    private static int length(Node l){
        int count = 0;
        while(l != null){
            count++;
            l = l.next;
        }
        return count;
    }

    private static Node padding(Node l, int s){
        while(s-- > 0){
            Node pad = new Node(0);
            pad.next = l;
            l = pad;
        }
        return l;
    }
    
    private static Node AddSameSize(Node l1, Node l2) {
        if(l1 == null )
            return null;
        PartialSum sum = AddSameSizeHelper(l1, l2);
        if(sum.carry == 0)
            return sum.sum;
        else{
            Node result = new Node(sum.carry);
            result.next = sum.sum;
            sum.sum = result;
            return sum.sum;
        }
    }
    
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(2);
        Node result = function(l1, l2);
        
        while(result != null){
            System.out.print(result.data+" ");
            result = result.next;
        }
    }

    private static PartialSum AddSameSizeHelper(Node l1, Node l2) {
        if(l1 == null){
            PartialSum sum = new PartialSum();
            return sum;
        }
        PartialSum var = AddSameSizeHelper(l1.next, l2.next);
        int sum = l1.data + l2.data + var.carry;
        var.carry = sum / 10;
        Node test = new Node(sum%10);
        test.next = var.sum;
        var.sum = test;
        return var;
    }
    
}
