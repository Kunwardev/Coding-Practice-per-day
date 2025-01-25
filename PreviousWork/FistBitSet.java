/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Misc;

/**
 *
 * @author DEV
 */
public class FistBitSet {
    
    private static int onesComplement(int n) 
    { 
       int number_of_bits =  
               (int)(Math.floor(Math.log(n) / 
                             Math.log(2))) + 1; 
  
        // XOR the given integer with poe(2, 
        // number_of_bits-1 and print the result 
        return ((1 << number_of_bits) - 1) ^ n; 
    } 
    
    private static double function(int number){
        double result = 0;
        int complement = onesComplement(number)+1;
        result = Math.log(complement & number) / Math.log(2);
        return result+1;
    }
    
    public static void main(String[] args) {
        System.out.println(function(18));
    }
    
}
