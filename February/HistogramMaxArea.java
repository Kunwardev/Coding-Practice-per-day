package February;

import java.util.Stack;

public class HistogramMaxArea {
    
    private int getMaxArea(int arr[]) {
        // your code here
        Stack<Integer> st = new Stack<>();
        int length = arr.length;
        int maxArea = 0;
        for(int i=0;i<length;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int tpIndex = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, (arr[tpIndex] * width));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int tpIndex = st.pop();
            int width = st.isEmpty() ? length : length - st.peek()-1;
            maxArea = Math.max(maxArea, (arr[tpIndex] * width));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {60, 20, 50, 40, 10, 50, 60};
        HistogramMaxArea h = new HistogramMaxArea();
        System.out.println(h.getMaxArea(arr));
    }

}
