package January;

import java.util.HashMap;
import java.util.Map;

import DataStructure.DoubleLinkedList;

public class LRUCache {
    private int capacity;
    private Map<Integer, DoubleLinkedList> cacheMap;
    private DoubleLinkedList head;
    private DoubleLinkedList tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new DoubleLinkedList(-1, -1);
        this.tail = new DoubleLinkedList(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        DoubleLinkedList node = cacheMap.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            DoubleLinkedList oldNode = cacheMap.get(key);
            remove(oldNode);
        }

        DoubleLinkedList node = new DoubleLinkedList(key, value);
        cacheMap.put(key, node);
        add(node);

        if (cacheMap.size() > capacity) {
            DoubleLinkedList nodeToDelete = tail.prev;
            remove(nodeToDelete);
            cacheMap.remove(nodeToDelete.key);
        }
    }

    private void add(DoubleLinkedList node) {
        DoubleLinkedList nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    private void remove(DoubleLinkedList node) {
        DoubleLinkedList prevNode = node.prev;
        DoubleLinkedList nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

