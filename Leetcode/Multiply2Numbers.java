package Leetcode;

public class Multiply2Numbers {
    
    private String multiply(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        if (len1 == 0 || len2 == 0)
            return "Empty";
        int[] result = new int[len1 + len2];
        int iA = 0, iB = 0;
        int carry = 0;
        for(int i=len1-1;i>=0;i--){
            carry = 0;
            iB = 0;
            int n1 = a.charAt(i)-'0';
            for(int j=len2-1;j>=0;j--){
                int n2 = b.charAt(j)-'0';
                int sum = n1*n2 + carry + result[iA+iB];
                carry = sum / 10;
                result[iA+iB] = sum%10;
                iB++;
            }
            result[iA+iB] += carry;
            iA++;
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;
        if (i == -1)
            return "0";
        
       String s = "";
            
        while (i >= 0)
            s += (result[i--]);
        
        return s;
    }

    public static void main(String[] args) {
        Multiply2Numbers m = new Multiply2Numbers();
        String result = m.multiply("001230", "4");
        System.out.println(result);
    }
}
