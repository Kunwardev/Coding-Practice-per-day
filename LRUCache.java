/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Misc;

import java.util.LinkedList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author kunwar
 */
public class LRUCache {
    
    private Deque<Integer> dequeu;
    private HashSet<Integer> set;
    private final int lru_size;

    public LRUCache(int size) {
        this.lru_size = size;
        dequeu = new LinkedList<>();
        set = new HashSet<>();
    }
    
    public void add(int p){
        if(!set.contains(p)){
            if(dequeu.size() == lru_size){
                int last = dequeu.removeLast();
                set.remove(last);
            }
        } else{
            dequeu.remove(p);
        }
        dequeu.push(p);
        set.add(p);
    }
    
    public void display(){
        Iterator<Integer> it = dequeu.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
    
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(1);
        lru.add(2);
        lru.add(5);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        lru.display();
    }
    
}
