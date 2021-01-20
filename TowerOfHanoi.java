/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Recursion;

/**
 *
 * @author DEV
 */
public class TowerOfHanoi {
    
    private static void function(int n, char from, char to, char aux){
        if(n == 1){
            System.out.println("Move from " + from + " to " + to);
            return;
        }
        function(n-1, from, aux, to);
        System.out.println("Move from " + from + " to " + to);
        function(n-1, aux, to, from);
    }
    
    public static void main(String[] args) {
        int n = 4;
        function(n, 'A', 'C', 'B');
    }
    
}
