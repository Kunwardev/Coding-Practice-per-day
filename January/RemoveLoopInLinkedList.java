package January;

import DataStructure.Node;

public class RemoveLoopInLinkedList {
    public static void removeLoop(Node head) {
        // code here
        Node slow = head, fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != null && fast.next != null && slow != fast);
        if(fast == null || fast.next == null)
            return;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        while(fast.next != slow){
            fast = fast.next;
        }
        fast.next = null;
    }
}
