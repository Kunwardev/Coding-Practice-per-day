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
public class MinStack {

    public static Stack<Integer> st;
    public static int minEle;
    
    private static void pushM(int x){
        if(st.isEmpty()){
            minEle = x;
            st.push(x);
        }
        if(x >= minEle){
            st.push(x);
        } else{
            st.push(2*x - minEle);
            minEle = x;
        }
    }
    
    private static void pullM(){
        if(st.isEmpty()){
            System.out.println("The Stack is Empty");
            return;
        }
        int y = st.pop();
        if(y < minEle){
            minEle = 2*minEle - y;
        }
    }
    
    private static int extractMin(){
        return minEle;
    }
    
    public static void main(String[] args) {
        st = new Stack<>();
        pushM(3);
        pushM(5);
        System.out.println(extractMin());
        pushM(2);
        pushM(1);
        System.out.println(extractMin());
        pullM();
        System.out.println(extractMin());
    }
    
}
