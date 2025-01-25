/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author DEV
 */
public class Replace0with5 {
    
    private static int recursion(int number){
        if(number == 0)
            return 0;
        int digit = number % 10;
        if(digit == 0)
            digit = 5;
        return recursion(number / 10 ) * 10 + digit;
    }
    
    private static int iterative(int number){
        int result = 0;
        int decimalPlace = 1;
        if(number == 0)
            return 5;
        while(number > 0){
            if(number % 10 == 0){
                result += (5 * decimalPlace);
            } else{
                result += (number % 10) * decimalPlace;
            }
            number /= 10;
            decimalPlace *= 10;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(recursion(1068));
        System.out.println(iterative(6004));
    }
    
}
