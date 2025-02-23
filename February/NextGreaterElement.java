package February;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    private ArrayList<Integer> functionUsingStack(int[] arr){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        int length = arr.length;
        result.add(-1);
        st.push(arr[length-1]);
        for(int i=length-2;i>=0;i--){
            while(!st.isEmpty() && arr[i] > st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                result.add(0, -1);
            }else{
                result.add(0, st.peek());
            }
            st.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        NextGreaterElement n = new NextGreaterElement();
        System.out.println(n.functionUsingStack(arr));
    }
}
