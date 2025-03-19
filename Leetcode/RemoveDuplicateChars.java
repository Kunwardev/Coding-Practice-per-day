package Leetcode;

import java.util.Stack;

public class RemoveDuplicateChars {
    
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty() || st.peek() != s.charAt(i)){
                st.push(s.charAt(i));
            }else{
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char a: st){
            sb.append(a);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateChars remover = new RemoveDuplicateChars();
        // Test case 1: Removing adjacent duplicates
        String test1 = "abbaca";
        String result1 = remover.removeDuplicates(test1);
        System.out.println("Test 1 - Expected: 'ca', Got: '" + result1 + "'");

        // Test case 2: No adjacent duplicates
        String test2 = "abcdef";
        String result2 = remover.removeDuplicates(test2);
        System.out.println("Test 2 - Expected: 'abcdef', Got: '" + result2 + "'");

        // Test case 3: All characters are the same
        String test3 = "aaaaaa";
        String result3 = remover.removeDuplicates(test3);
        System.out.println("Test 3 - Expected: '', Got: '" + result3 + "'");

        // Test case 4: Mixed characters with adjacent duplicates
        String test4 = "aabccba";
        String result4 = remover.removeDuplicates(test4);
        System.out.println("Test 4 - Expected: 'a', Got: '" + result4 + "'");

        // Test case 5: Single character
        String test5 = "a";
        String result5 = remover.removeDuplicates(test5);
        System.out.println("Test 5 - Expected: 'a', Got: '" + result5 + "'");
    }

}
