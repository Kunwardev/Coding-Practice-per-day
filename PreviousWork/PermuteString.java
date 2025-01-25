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
public class PermuteString {
    
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    
    private static void function(String str, int l, int r){
        if(l == r)
            System.out.println(str);
        else{
            for(int i=l;i<=r;i++){
                str = swap(str, l, i);
                function(str, l+1, r);
                str = swap(str, l, i);
            }
        }
    }
    
    public static void main(String[] args) {
        function("ABC", 0, 2);
    }
    
}
