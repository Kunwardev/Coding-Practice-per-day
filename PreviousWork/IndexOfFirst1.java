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
public class IndexOfFirst1 {
    
    private static int function(int[] arr){
        int index = -1;
        int low = 0, high = arr.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(arr[mid] == 1 && (mid==0 || arr[mid-1] == 0)){
                index = mid;
                break;
            } else if (arr[mid] == 1){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1};
        System.out.println(function(arr));
    }
    
}
