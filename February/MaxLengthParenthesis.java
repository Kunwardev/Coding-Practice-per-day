package February;

public class MaxLengthParenthesis {
    private int maxLength(String s) {
        // code here
        int open = 0, close = 0;
        int length = s.length();
        int maxLen = 0;
        for(int i=0;i<length;i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){
                maxLen = Math.max(maxLen, 2*close);
            }
            else if(close > open){
                close = 0;
                open = 0;
            }
        }
        open = 0; close = 0;
        for(int i=length-1;i>=0;i--){
            if(s.charAt(i) == ')'){
                close++;
            }else{
                open++;
            }
            if(open == close){
                maxLen = Math.max(maxLen, 2*open);
            }else if(close < open){
                close = 0;
                open = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxLengthParenthesis m = new MaxLengthParenthesis();
        System.out.println(m.maxLength("(())))(())"));
    }
}
