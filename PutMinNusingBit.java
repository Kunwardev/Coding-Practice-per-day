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
public class PutMinNusingBit {
    
    private static int function(int n, int m, int i, int j)
    {
        int allOnes = ~0;
        int left = allOnes << (j+1);
        int right = ((1<<i)-1);
        int mask = left | right;
        int n_cleared = n&mask;
        int m_included = m << i;
        return n_cleared | m_included;
    }
    
    public static void main(String[] args) {
        
    }
    
}
