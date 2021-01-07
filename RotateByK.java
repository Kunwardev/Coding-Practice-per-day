/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author DEV
 */
public class RotateByK {
    
    private static int numberOfDigits(int n){
        int digit = 0;
        while(n > 0){
            digit++;
            n/=10;
        }
        return digit;
    }
    
    private static void function(int number, int k){
        int n_digit = numberOfDigits(number);
        k = ((k % n_digit) + n_digit) % n_digit;
        System.out.println("sdf"+k);
        int first_part = number / (int)Math.pow(10, n_digit-k);
        
        number = number % (int)Math.pow(10, n_digit-k);
        int count = numberOfDigits(first_part);
        number = number * (int) Math.pow(10, count) + first_part;
        System.out.println(number);
    }
    
    public static void main(String[] args) {
        int num = 12345, k = -3;
        function(num, k);
    }
    
}
