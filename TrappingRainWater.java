 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author DEV
 */
public class TrappingRainWater {
    
    private static int function(int[] arrays){
        
        int length = arrays.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int index_i = 0, result = 0;
        left[0] = arrays[0]; right[length-1] = arrays[length-1];
        
        for(index_i=1;index_i<length; index_i++){
            left[index_i] = Math.max(left[index_i-1], arrays[index_i]);
        }
        
        for(index_i=length-2;index_i >=0; index_i--){
            right[index_i] = Math.max(right[index_i+1], arrays[index_i]);
        }
        
        for(index_i=0;index_i<length;index_i++){
            result += (Math.min(left[index_i], right[index_i]) - arrays[index_i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arrays = new int[]{2, 0, 2};
        System.out.println(function(arrays));
    }
    
}
