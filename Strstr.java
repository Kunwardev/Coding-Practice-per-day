/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.String;

/**
 *
 * @author DEV
 */
public class Strstr {
    
    private static int function(String s1, String s2){
        
        int M = s1.length();
        int N = s2.length();
        
        for (int i = 0; i <= N - M; i++) { 
            int j; 
  
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) 
                    != s1.charAt(j)) 
                    break; 
  
            if (j == M) 
                return i; 
        } 
  
        return -1; 
        
    }
    
    
    public static void main(String[] args) {
        String s1 = "fr"; 
        String s2 = "geeksforgeeks"; 
        
        System.out.println(function(s1, s2));
        
    }
    
}
