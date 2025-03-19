package Leetcode;

import java.util.Stack;

public class RemoveAllDuplicateChars {
    
    private static String removeAllChars(String s){
        Stack<Character> st = new Stack<>();
        boolean removeTop = false;
        for(int i=0;i<s.length();i++){
            if(st.isEmpty() || st.peek() != s.charAt(i)){
                if(removeTop){
                    st.pop();
                    removeTop = false;
                    i--;
                    continue;
                }
                st.push(s.charAt(i));
            }else{
                removeTop = true;
            }
        }
        if(removeTop)
            st.pop();
        System.out.println(st+" "+removeTop);
        StringBuilder sb = new StringBuilder();
        for(Character c: st)
            sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cddabbbacd";
        System.out.println(removeAllChars(s));
    }

}
