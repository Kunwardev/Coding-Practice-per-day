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
public class RecursiveMultiply {
    
    private static int function(int a, int b){
        int smaller, bigger;
        if(a < b){
            smaller = a;
            bigger = b;
        } else{
            smaller = b;
            bigger = a;
        }
        return functionHelper(smaller, bigger);
    }

    private static int functionHelper(int smaller, int bigger) {
        if(smaller == 0)
            return 0;
        else if(smaller == 1)
            return bigger;
        int s = smaller >> 1;
        int halfProduct = functionHelper(s, bigger);
        if(smaller % 2 == 0){
            return halfProduct + halfProduct;
        } else
            return halfProduct + halfProduct + bigger;
    }
    
    public static void main(String[] args) {
        System.out.println(function(30, 35));
    }
    
}
