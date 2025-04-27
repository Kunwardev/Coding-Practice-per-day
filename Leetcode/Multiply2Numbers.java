package Leetcode;

public class Multiply2Numbers {
    // Updated to try again and also involved negative numbers
    private String multiply(String a, String b){
        boolean isNegative = false;
        if(a.charAt(0) == '-'){
            isNegative = !isNegative;
            a = a.substring(1);
        }
        if(b.charAt(0) == '-'){
            isNegative = !isNegative;
            b = b.substring(1);
        }
        int length1 = a.length();
        int length2 = b.length();
        int iA = 0, iB = 0, carry = 0;
        int[] result = new int[length1 + length2];
        for(int j=length1-1;j>=0;j--){
            iB = 0; carry = 0;
            int n1 = a.charAt(j)-'0';
            for(int k=length2-1;k>=0;k--){
                int n2 = b.charAt(k)-'0';
                int sum = (n1 * n2) + carry + result[iA+iB];
                result[iA+iB] = sum % 10;
                carry = sum / 10;
                iB++;
            }
            result[iA+iB] += carry;
            iA++;
        }
        int i = result.length - 1;
        while(i >= 0 && result[i] == 0)
            i--;
        if(i == -1)
            return "0";
        String s = "";
        while(i >= 0){
            s += result[i--];
        }
        return isNegative ? "-"+s : s;
    }

    public static void main(String[] args) {
        Multiply2Numbers m = new Multiply2Numbers();
        String result = m.multiply("-001230", "-4");
        System.out.println(result);
    }
}
