/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingCodingInterview;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author kunwar
 */
public class CheckIfStringsArePermutation {
    
    // You can also calculate the number of characters
    
    private static String sort(String str){
        char[] charStr = new char[str.length()];
        Arrays.sort(charStr);
        return new String(charStr);
    }
    
    private static boolean function(String str_1, String str_2){
        if(str_1.length() != str_2.length())
            return false;
        return sort(str_1).equals(sort(str_2));
    }
    
}
