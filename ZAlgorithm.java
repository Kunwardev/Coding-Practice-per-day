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
public class ZAlgorithm {

    private static void ZAlgo(String str, int[] Z){
        int length = Z.length;
        int left = 0, right = 0;
        
        for(int i=0; i<length; i++){
            
            if(i < right){
                left = right = i;
                while(right < length && str.charAt(right-left) == str.charAt(right)){
                    right++;
                }
                Z[i] = right - left;
                right--;
            }
            else{
                int k = i-left;
                if(Z[k] < right - i + 1){
                    Z[i] = Z[k];
                }else{
                    left = i;
                    while(right < length && str.charAt(right-left) == str.charAt(right)){
                    right++;
                    }
                    Z[i] = right - left;
                    right--;
                }
            }
        }
        
    }
    
}
