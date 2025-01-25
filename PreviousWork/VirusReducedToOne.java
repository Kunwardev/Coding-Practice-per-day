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
public class VirusReducedToOne {
    
    private static int functionDP(int number, int steps, int[] results){
        if(number == 1)
            return 0;
        if(results[number] != 0)
            return results[number];
        int res = Integer.MAX_VALUE;
        if(number % 2 == 0){
            res = Math.min(res, functionDP(number/2, steps+1, results));
        } else{
            res = Math.min(functionDP(number-1, steps+1, results), functionDP(number+1, steps+1, results));
        }
        results[number] = 1 + res;
        return results[number];
    }
    
    public static void main(String[] args) {
        int[] results = new int[20];
        System.out.println(functionDP(17, 0, results));
    }

    
    
}
