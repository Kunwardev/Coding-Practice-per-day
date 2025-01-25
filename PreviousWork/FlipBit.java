/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author kunwar
 */
public class FlipBit {
    private static int function(int bit){
        return (1^bit);
    }
    
    private static int change(int number){
        return ~number;
    }
    
    public static void main(String[] args) {
        System.out.println(function(7));
        System.out.println(change(5));
    }
    
}
