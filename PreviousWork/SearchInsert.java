/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author kunwar
 */
public class SearchInsert {
    
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]){
        return nums.length;
    }
 
    int l=0;
    int r=nums.length-1;
 
    while(l<r){
        int m = l+(r-l)/2;
        if(target>nums[m]){
            l=m+1;
        }else{
            r=m;
        }
    }
 
    return l;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,7};
        SearchInsert s = new SearchInsert();
        System.out.println(s.searchInsert(arr, 0));
        System.out.println(s.searchInsert(arr, 5));
        System.out.println(s.searchInsert(arr, 8));
    }
    
}
