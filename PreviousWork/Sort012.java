/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author DEV
 */
public class Sort012 {
    
    private static void function(int[] arr){
        int length = arr.length;
        int low = 0, mid = 0, high = length-1, temp = 0;
        
        while(mid <= high){
            switch(arr[mid]){
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;mid++;
                    break;
                    
                case 1:
                    mid++;
                    break;
                
                case 2:
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
            }
        }       
    }
    
    public static void main(String[] args) {
        
        int[] arr = { 1, 0, 2, 1, 1, 2, 0 };
        function(arr);
        for(int i: arr){
            System.out.print(i+"  ");
        }
        
    }
    
}
