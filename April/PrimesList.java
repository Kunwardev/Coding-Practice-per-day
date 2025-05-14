package April;

import java.util.Arrays;

import DataStructure.Node;

public class PrimesList {
    
    boolean[] prime;
    private void sieveOfErasto(){
        prime = new boolean[10001];
        Arrays.fill(prime, true);
        for(int p=2;p*p < 10001;p++){
            if(prime[p]){
                for(int i=p*p;i*i < 10001; i+=p){
                    prime[i] = false;        
                }
            }
        }
    }

    private int findNearestPrime(int n){
        if(prime[n])
            return n;
        int lower = n - 1;
        int higher = n + 1;
        while(true){
            if(lower > 1 && prime[lower])
                return lower;
            if(higher < 10001 && prime[higher])
                return higher;
            lower--;
            higher++;
        }
    }

    private Node changeNode(Node head){
        Node temp = head;
        while(temp != null){
            temp.data = findNearestPrime(temp.data);
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        PrimesList primesList = new PrimesList();

        // Test case 1: List with mixed numbers
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(20);
        primesList.sieveOfErasto();
        Node result1 = primesList.changeNode(head1);
        System.out.print("Test case 1: ");
        printList(result1); // Expected output: 11 -> 13 -> 19

        // Test case 2: List with all prime numbers
        Node head2 = new Node(3);
        head2.next = new Node(7);
        head2.next.next = new Node(11);
        primesList.sieveOfErasto();
        Node result2 = primesList.changeNode(head2);
        System.out.print("Test case 2: ");
        printList(result2); // Expected output: 3 -> 7 -> 11

        // Test case 3: List with all non-prime numbers
        Node head3 = new Node(4);
        head3.next = new Node(6);
        head3.next.next = new Node(8);
        primesList.sieveOfErasto();
        Node result3 = primesList.changeNode(head3);
        System.out.print("Test case 3: ");
        printList(result3); // Expected output: 3 -> 5 -> 7

        // Test case 4: Single node list
        Node head4 = new Node(14);
        primesList.sieveOfErasto();
        Node result4 = primesList.changeNode(head4);
        System.out.print("Test case 4: ");
        printList(result4); // Expected output: 13

        // Test case 5: Empty list
        Node head5 = null;
        primesList.sieveOfErasto();
        Node result5 = primesList.changeNode(head5);
        System.out.print("Test case 5: ");
        printList(result5); // Expected output: (empty list)
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

}
