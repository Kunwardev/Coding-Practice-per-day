package Leetcode;

import java.util.Stack;

public class MinRemoveToMakeValidParenthesis {
    
    public String minRemoveToMakeValid(String s){
        Stack<Character> st = new Stack<>();
        int length = s.length();
        int leftParenCount = 0, rightParenCount = 0;
        for(int i=0;i<length;i++){
            if(s.charAt(i) == '('){
                leftParenCount++;
            }
            if(s.charAt(i) == ')'){
                rightParenCount++;
            }
            if(leftParenCount < rightParenCount){
                rightParenCount--;
                continue;
            }else
                st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char pop = st.pop();
            if(rightParenCount < leftParenCount && pop == '('){
                leftParenCount--;
            }else{
                sb.append(pop);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        // Test case 1
        MinRemoveToMakeValidParenthesis solution = new MinRemoveToMakeValidParenthesis();
        String input1 = "lee(t(c)o)de)";
        String expectedOutput1 = "lee(t(c)o)de";
        System.out.println("Test case 1: " + (solution.minRemoveToMakeValid(input1).equals(expectedOutput1) ? "Passed" : "Failed"));

        // Test case 2
        String input2 = "a)b(c)d";
        String expectedOutput2 = "ab(c)d";
        System.out.println("Test case 2: " + (solution.minRemoveToMakeValid(input2).equals(expectedOutput2) ? "Passed" : "Failed"));

        // Test case 3
        String input3 = "))((";
        String expectedOutput3 = "";
        System.out.println("Test case 3: " + (solution.minRemoveToMakeValid(input3).equals(expectedOutput3) ? "Passed" : "Failed"));

        // Test case 4
        String input4 = "(a(b(c)d)";
        String expectedOutput4 = "(a(bc)d)";
        System.out.println("Test case 4: " + (solution.minRemoveToMakeValid(input4).equals(expectedOutput4) ? "Passed" : "Failed"));

        // Test case 5
        String input5 = "a(b(c)d)e)";
        String expectedOutput5 = "a(b(c)d)e";
        System.out.println("Test case 5: " + (solution.minRemoveToMakeValid(input5).equals(expectedOutput5) ? "Passed" : "Failed"));
    }

}
