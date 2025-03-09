package Leetcode;

import java.util.Stack;

public class StringWithIDPattern {
    
    public String smallestNumber(String pattern) {
        int length = pattern.length();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=length;i++){
            st.push(i+1);
            if(i==length || pattern.charAt(i)=='I'){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringWithIDPattern s = new StringWithIDPattern();
        System.out.println(s.smallestNumber("IIDDI"));
    }

}
