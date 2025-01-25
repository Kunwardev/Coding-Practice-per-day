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
public class BinaryNumberMultipleOf3 {
    
    // This function will fail when the length exceeds the int size
    private static boolean function(String s){
        int length = s.length();
        int difference = 0;
        for(int i=0;i<length;i+=2){
            difference += (s.charAt(i) == '1' ? 1 : 0);
        }
        for(int i=1;i<length;i+=2){
            difference -= (s.charAt(i) == '1' ? 1 : 0);
        }
        return difference == 0;
    }
    
    // Try using DFA ( Deterministic Finite Automata
    private static boolean functionEfficient(String s){
        int length = s.length();
        char state = '0';
        for(int i=0;i<length;i++){
            char digit = s.charAt(i);
            switch(state){
                case '0':
                    if(digit == '1'){
                        state = '1';
                    }
                break;
                case '1':
                    if(digit == '0'){
                        state = '2';
                    } else{
                        state = '0';
                    }
                break;
                case '2':
                    if(digit == '0'){
                        state = '1';
                    }
                break;
            }
        }
        return (state == '0');
    }
    
    public static void main(String[] args) {
        System.out.println(function("001100011"));
        System.out.println(functionEfficient("001100011"));
    }
    
}
