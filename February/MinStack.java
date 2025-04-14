package February;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    int minNumber;

    public MinStack(){
        this.st = new Stack<>();
    }
    private void push(int data){
        if(st.isEmpty()){
            st.push(data);
            this.minNumber = data;
        }
        if(st.peek() > data){
            st.push(2*data - minNumber);
            this.minNumber = data;
        }else{
            st.push(data);
        }
    }

    private void pop(){
        if(st.isEmpty()){
            minNumber = -1;
            return;
        }
        int data = st.pop();
        if(data < minNumber){
            minNumber = 2*minNumber-data;
        }
    }

    private int getMin(){
        return minNumber;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(6);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.minNumber);
        ms.pop();
        ms.pop();
        System.out.println(ms.minNumber);
    }

}
