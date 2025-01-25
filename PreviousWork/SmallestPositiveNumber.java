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
public class SmallestPositiveNumber {
    
    private static void function(int n){
        if(n > 45){
            System.out.println("-1");
            return;
        }
        String result = "";
        
        int digit = 9;
        
        while(n > digit){
            result = (char)('0'+digit) + result;
            n -= digit;
            digit--;
    //        System.out.println(result + " " + digit + " " + n);
        }
        if(n > 0){
            result = (char)('0'+n) + result;
        }
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        function(19);
    }
    
}
