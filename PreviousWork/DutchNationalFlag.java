/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author DEV
 * There are three indices – low, mid and high. Initially, 
 * the value of low = mid = 1 and high = N.
 * If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
    Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
    If the element is 2 then swap it with an element in high range.
 */
public class DutchNationalFlag {
    
     private static void function(int[] arr){
         int length = arr.length;
         int low = 0, mid = 0, high = length - 1;
         int swapped = 0;
         
         while(mid <= high){
             switch(arr[mid]){
                case 0:{
                    swapped = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = swapped;
                    low++;
                    mid++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    swapped = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = swapped;
                    high--;
                    break;
                }
             }
         }
     }
     public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
         function(arr);
         for(int element: arr){
             System.out.print(element + "  ");
         }
    }
}
