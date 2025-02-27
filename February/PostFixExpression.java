package February;

import java.util.Stack;

public class PostFixExpression {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int a1, a2;
        for(String s: arr){
            switch(s){
                case "+":
                    a1 = st.pop();
                    a2 = st.pop();
                    st.push(a1+a2);
                    break;
                case "-":
                    a1 = st.pop();
                    a2 = st.pop();
                    st.push(a2-a1);
                    break;
                case "*":
                    a1 = st.pop();
                    a2 = st.pop();
                    st.push(a1*a2);
                    break;
                case "/":
                    a1 = st.pop();
                    a2 = st.pop();
                    st.push(a2/a1);
                    break;
                default:
                    st.push(Integer.parseInt(s));
                    break;
            }
        }
        return st.isEmpty() ? -1 : st.pop();
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"2", "3", "1", "*", "+", "9", "-"};
        PostFixExpression p = new PostFixExpression();
        System.out.println(p.evaluate(arr));
    }
}
