package February;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {
    
    // Brute Force Method
    private ArrayList<Integer> stockSpan(int[] stock){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<stock.length;i++){
            int span = 0;
            int j=i;
            while(j>=0 && stock[j] <= stock[i]){
                span++;
                j--;
            }
            result.add(span);
        }
        return result;
    }

    // Using Stack
    private ArrayList<Integer> stockSpanStack(int[] stock){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        result.add(1);
        st.push(0);
        int n = stock.length;
        for(int i=1;i<n;i++){
            if(stock[i] < stock[st.peek()]){
                result.add(i-st.peek());
            } else{
                while(!st.isEmpty() && stock[i] >= stock[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    result.add(i+1);
                } else{
                    result.add(i-st.peek());
                }
            }
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] stock = new int[]{100, 80, 60, 70, 60, 75, 85};
        StockSpanProblem s = new StockSpanProblem();
        System.out.println(s.stockSpan(stock));
        System.out.println(s.stockSpanStack(stock));
    }

}
