/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingCodingInterview;

/**
 *
 * @author kunwar
 */
public class IsUnique {
    
    private static boolean inUniqueChars(String str){
        if(str.length() > 128)
            return false;
        
        boolean[] charset = new boolean[128];
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if(charset[val])
                return false;
            charset[val] = true;
        }
        return true;
    }
    
}
