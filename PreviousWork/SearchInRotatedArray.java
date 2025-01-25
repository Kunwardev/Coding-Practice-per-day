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
public class SearchInRotatedArray {
    
    private static int search(int a[], int left, int right, int x) {
        int mid = (left + right);
        if (x == a[mid]) {
            return mid;
        }
        if (right < left) {
            return -1;
        }
        if (a[left] < a[mid]) {
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
            return search(a, mid + 1, right, x);
            }
        } 
        else if (a[mid] < a[left]) {
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            }
            else {
                return search(a, left, mid - 1, x);
            }
        }
        else if (a[left] == a[mid]) {
            if (a[mid] != a[right]) {
                return search(a, mid + 1, right , x);
        } else { 
        int result = search(a, left, mid - 1, x);
        if (result == -1) {
            return search(a, mid + 1, right, x);
        } else {
        return result;
        }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2, 2, 2, 2, 2, 2 ,2 , 2, 2, 2};
        System.out.println(search(arr, 0, arr.length-1, 0));
    }
    
    
}
