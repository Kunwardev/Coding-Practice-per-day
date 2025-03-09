package February;

import java.util.Stack;

public class EncodingString{
    static String decodeString(String s) {
        // code here
        int count = 0;
        Stack<Integer> intSt = new Stack<>();
        Stack<Character> charSt = new Stack<>();
        char[] sArr = s.toCharArray();
        for(int i=0;i<sArr.length;i++){
            //System.out.println(charSt);
            if(Character.isDigit(sArr[i])){
                String num = "";
                while(Character.isDigit(sArr[i])){
                    num = num+sArr[i];
                    i++;
                }
                i--;
                intSt.push(Integer.parseInt(num));
            }else if(sArr[i] == ']'){
                count++;
                int rep = intSt.pop();
                StringBuilder repS = new StringBuilder();
                while(!charSt.isEmpty() && charSt.peek() != '['){
                    repS.append(charSt.pop());
                }
                repS.reverse();
                StringBuilder sb = new StringBuilder();
                while(rep > 0){
                    sb.append(repS);
                    rep--;
                }
                charSt.pop();
                //System.out.println("B"+_a+" -> "+repS);
                for(char put: sb.toString().toCharArray()){
                    charSt.push(put=='[' ? ' ' : put);
                }
            }else{
                charSt.push(sArr[i]);
            //    System.out.println("E"+sArr[i]);
            }
        //    System.out.println(charSt);
        }
        StringBuilder result = new StringBuilder();
        while(!charSt.isEmpty()){
            result.append(charSt.pop());
        }
        result.reverse();
        //System.out.println(charSt);
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "2[c3[ba]]";
        EncodingString a = new EncodingString();
        System.out.println(a.decodeString(s));
    }
}