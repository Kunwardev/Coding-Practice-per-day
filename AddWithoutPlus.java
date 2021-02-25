/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingCodingInterview;

/**
 *
 * @author kunwar
 */
public class AddWithoutPlus {
    
    private static int function(int a, int b){
        if(b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return function(sum, carry);
    }
    
    public static void main(String[] args) {
        System.out.println(function(2, 3));
    }
    
}
