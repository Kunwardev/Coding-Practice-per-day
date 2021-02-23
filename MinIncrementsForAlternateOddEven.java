/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author kunwar
 */
public class MinIncrementsForAlternateOddEven {
    
    private static int function(int[] arr){
        int isEven = 0;
        for(int i=0;i<arr.length; i++){
            if(i%2 == 0){
                if(arr[i] % 2 == 1)
                    isEven++;
            } else{
                if(arr[i] % 2 == 0)
                    isEven++;
            }
        }
        return Math.min(isEven, arr.length-isEven);
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 4, 2};
        System.out.println(function(arr));
    }
    
}
