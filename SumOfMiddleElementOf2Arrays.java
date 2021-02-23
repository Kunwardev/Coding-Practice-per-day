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
public class SumOfMiddleElementOf2Arrays {
    
    private static int function(int[] arr1, int []arr2, int length){
        int i=0, j=0, k=length-1;
        while(k > 0){
            if(arr1[i] == arr2[j]){
                i++;
                j++;
                k--;
                k--;
            } else if(arr1[i] < arr2[j]){
                i++;
                k--;
            } else{
                j++;
                k--;
            }
        }
        return (arr1[i] + arr2[j]);
    }
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,4,6,10};
        int[] arr2 = new int[]{4,5,6,9,12};
        System.out.println(function(arr1, arr2, 5));
    }
    
}
