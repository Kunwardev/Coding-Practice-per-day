package Leetcode;

import DataStructure.Node;

public class MergeKLists {
    
    public static Node merge2Lists(Node a, Node b){
        Node temp = new Node(-1);
        Node head = temp;
        while(a != null && b != null){
            if(a.data > b.data){
                temp.next = b;
                b = b.next;
            }else{
                temp.next = a;
                a = a.next;
            }
            temp = temp.next;
        }
        if(a != null)
            temp.next = a;
        else if(b != null)
            temp.next = b;
        return head;
    }

    public Node mergeKLists(Node[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        Node head = merge2Lists(lists[0], lists[1]);
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(3);
        a.next.next = new Node(5);
        Node b = new Node(2);
        b.next = new Node(4);
        b.next.next = new Node(6);
        Node head = merge2Lists(a, b);
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }

    }

}
