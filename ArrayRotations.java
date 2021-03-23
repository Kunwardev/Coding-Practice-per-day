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
public class ArrayRotations {
    
    // Using Temp Array
    private static void tempArrayFunction(int[] arr, int d, int n){
        int[] temp = new int[d];
        
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }
        
        for(int i=d;i<n;i++){
            arr[i-d] = arr[i];
        }
        int k = 0;
        for(int i=n-d;i<n;i++){
            arr[i] = temp[k++];
        }
    }
    
    // Rotating By One
    private static void leftRoateByOne(int[] arr, int n){
        int i, temp;
        temp = arr[0];
        for(i=0;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }
    
    private static void leftRotate(int[] arr, int d, int n){
        for(int i=0;i<d;i++)
            leftRoateByOne(arr, n);
    }
    
    // Rotating with Juggling Algorithm
    private static void juggle(int[] arr, int d, int n){
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for(i=0;i<g_c_d;i++){
            temp = arr[i];
            j = i;
            while(true){
                k = j + d;
                if(k >= n){
                    k = k-n;
                }
                if(k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
    
    private static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        //tempArrayFunction(arr, 3, arr.length);
        //leftRotate(arr, 3, arr.length);
        juggle(arr, 3, arr.length);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    
}
