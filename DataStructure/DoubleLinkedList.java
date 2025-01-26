package DataStructure;

public class DoubleLinkedList {
    public int key;
    public int value;
    public DoubleLinkedList next;
    public DoubleLinkedList prev;

    public DoubleLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}