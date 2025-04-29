package April;

import DataStructure.Node;

public class SortLinkedList012 {

    public Node sort(Node head){
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        Node temp0 = dummy0;
        Node temp1 = dummy1;
        Node temp2 = dummy2;

        Node curr = head;
        while(curr != null){
            if(curr.data == 0){
                temp0.next = curr;
                temp0 = temp0.next;
            }else if(curr.data == 1){
                temp1.next = curr;
                temp1 = temp1.next;
            }else{
                temp2.next = curr;
                temp2 = temp2.next;
            }
            curr = curr.next;
        }
        temp0.next = (dummy1.next != null) ? dummy1.next : dummy2.next;
        temp1.next = dummy2.next;
        temp2.next = null;
        return dummy0.next;
    }
    
    public static void main(String[] args) {
        SortLinkedList012 sorter = new SortLinkedList012();

        // Test case 1: Linked list with 0s, 1s, and 2s
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(0);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = new Node(2);
        head1.next.next.next.next.next = new Node(0);

        System.out.println("Test case 1: Before sorting:");
        printList(head1);
        Node sortedHead1 = sorter.sort(head1);
        System.out.println("After sorting:");
        printList(sortedHead1);

        // Test case 2: Linked list with only 0s and 1s
        Node head2 = new Node(0);
        head2.next = new Node(1);
        head2.next.next = new Node(0);
        head2.next.next.next = new Node(1);

        System.out.println("Test case 2: Before sorting:");
        printList(head2);
        Node sortedHead2 = sorter.sort(head2);
        System.out.println("After sorting:");
        printList(sortedHead2);
        }
    
    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
