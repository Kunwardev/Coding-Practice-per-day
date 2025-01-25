/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author kunwar
 */
public class StringsEqualAfterOneSwap {
    
    private static boolean function(char[] x, char[] y){
        
        int xLength = x.length;
        int yLength = y.length;
        
        if(xLength != yLength)
            return false;
        
        int prev = -1, curr = -1, count = 0;
        
        for(int i=0; i<xLength; i++){
            
            if(x[i] != y[i]){
                count++;
                if(count > 2)
                    return false;
                prev = curr;
                curr = i;
            }
            
        }
        return (count == 2 && x[prev] == y[curr] && y[prev] == x[curr]);
    }
    
    public static void main(String[] args) {
        String s1 = "converse";
        String s2 = "conserve";
        System.out.println(function(s1.toCharArray(), s2.toCharArray()));
    }
    
}
