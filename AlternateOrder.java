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
public class AlternateOrder {
    
    private static void function(int[] arr){
        int i, length = arr.length;
        int max_index = length-1, min_index = 0;
        int max_element = arr[max_index]+1;
        
        for(i=0; i<length; i++){
            if(i%2 == 0){
                arr[i] += (arr[max_index]%max_element)*max_element;
                max_index--;
            } else{
                arr[i] += (arr[min_index]%max_element)*max_element;
                min_index++;
            }
        }
        
        for(int j: arr){
            System.out.print(j/max_element+" ");
        }
        
    }
    
    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3,4,5,6,7,8,9};
        function(arr);
    }
    
}
