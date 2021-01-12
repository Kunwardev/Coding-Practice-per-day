/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Stack;

import java.util.Stack;

/**
 *
 * @author DEV
 */
public class SortStack {
    
    private static void sort(Stack<Integer> st){
        if(!st.isEmpty()){
            int x = st.pop();
            sort(st);
            sortedInsert(st, x);
        }
    }

    private static void sortedInsert(Stack<Integer> st, int x) {
        if(st.isEmpty() || st.peek() < x){
            st.push(x);
            return;
        }
        int a = st.pop();
        sortedInsert(st, x);
        st.push(a);
    }
    
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(1);
        st.push(3);
        sort(st);
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
    
}
