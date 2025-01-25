/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

import java.util.Stack;

/**
 *
 * @author kunwar
 */
public class ReverseStack {
    
    private static void reverse(Stack<Integer> s){
        if(!s.isEmpty()){
            int pop = s.pop();
            reverse(s);
            reverseDown(s, pop);
        }
    }

    private static void reverseDown(Stack<Integer> s, int pop) {
        if(s.isEmpty()){
            s.push(pop);
            return;
        }
        int a = s.pop();
        reverseDown(s, pop);
        s.push(a);
    }
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
    
}
