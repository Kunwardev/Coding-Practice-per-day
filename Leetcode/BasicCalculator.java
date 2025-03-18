package Leetcode;

import java.util.Stack;

public class BasicCalculator {
    
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char prevOperator = '+';
        for(int i=0;i<=s.length();i++){
            char ch = (i<s.length()) ? s.charAt(i) : '\0';
            if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }
            if(!Character.isDigit(ch) && ch != ' ' ){
                if(prevOperator == '+') st.push(num);
                if(prevOperator == '-') st.push(-num);
                if(prevOperator == '*') st.push(num * st.pop());
                if(prevOperator == '/') st.push(st.pop() / num);

                prevOperator = ch;
                num = 0;
            }
        }
        System.out.println(st);
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        // Test case 1: Simple addition
        String expression1 = "3+2";
        int result1 = calculator.calculate(expression1);
        System.out.println("Test case 1: " + (result1 == 5 ? "Passed" : "Failed"));

        // Test case 2: Simple subtraction
        String expression2 = "5-3";
        int result2 = calculator.calculate(expression2);
        System.out.println("Test case 2: " + (result2 == 2 ? "Passed" : "Failed"));

        // Test case 3: Mixed operations
        String expression3 = "2+3*4";
        int result3 = calculator.calculate(expression3);
        System.out.println("Test case 3: " + (result3 == 14 ? "Passed" : "Failed"));

        // Test case 4: Division
        String expression4 = "8/4";
        int result4 = calculator.calculate(expression4);
        System.out.println("Test case 4: " + (result4 == 2 ? "Passed" : "Failed"));

        // Test case 5: Complex expression
        String expression5 = "10+2*6-4/2";
        int result5 = calculator.calculate(expression5);
        System.out.println("Test case 5: " + (result5 == 20 ? "Passed" : "Failed"));
    }

}
