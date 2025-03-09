package February;

import java.util.ArrayList;
import java.util.List;
import DataStructure.Node;

public class MergeKLinkedList {
    
    Node merge2List(Node a, Node b){
        Node temp = new Node(-1);
        Node head = temp;
        while(a != null && b != null){
            if(a.data < b.data){
                temp.next = a;
                a = a.next;
            } else{
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if(a != null){
            temp.next = a;
        }
        if(b != null){
            temp.next = b;
        }
        return head.next;
    }
    
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        while(arr.size() != 1){
            Node a = arr.remove(0);
            Node b = arr.remove(0);
            Node merged = merge2List(a, b);
            arr.add(merged);
        }
        Node head = arr.get(0);
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node h = new Node(1);
        h.next = new Node(3);
        Node p = new Node(2);
        p.next = new Node(5);
        Node q = new Node(4);
        q.next = new Node(7);
        Node r = new Node(6);
        r.next = new Node(8);
        List<Node> arr  = new ArrayList<>();
        arr.add(h);
        arr.add(p);
        arr.add(r);
        arr.add(q);
        MergeKLinkedList m = new MergeKLinkedList();
        m.mergeKLists(arr);
    }

}
