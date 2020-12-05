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
public class NumberToRomans {

    private static void function(int number){
        int[] num = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romans = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int index = 12;
        
        while(number > 0){
            int div = number / num[index];
            number = number % num[index];
            while(div > 0){
                System.out.print(romans[index]);
                div--;
            }
            index--;
        }
    }
    
    private static void faster_function(int number){
        String m[] = new String[]{"","M","MM","MMM"};
        String c[] = new String[]{"","C","CC","CCC", "CD","D","DC","DCC","DCCC","CM"};
        String x[] = new String[]{"","X","XX","XXX", "XL","L","LX","LXX","LXXX","XC"};
        String i[] = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        
        String thousands = m[number/1000];
        String hundreds = c[(number%1000)/100];
        String tens = x[(number%100)/10];
        String ones = i[number%10];
        System.out.println(thousands+hundreds+tens+ones);
    }
    
    public static void main(String[] args) {
        int number = 3549;
        function(number);
        System.out.println();
        faster_function(number);
    }
    
}
