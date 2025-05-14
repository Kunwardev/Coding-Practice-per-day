package April;

import java.util.Arrays;

public class NextPermutation {
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int i, int j){
        while(i < j){
            swap(arr, i++, j--);
        }
    }

    public void nextPerm(int[] arr){
        int length = arr.length;
        int i = length-2;
        while(i >=0 && arr[i] >= arr[i+1]){
            i--;
        }
        if(i >= 0){
            int j = length-1;
            while(arr[i] >= arr[j]){
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i+1, length-1);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();

        // Test case 1
        int[] testCase1 = {1, 2, 3};
        int[] expectedOutput1 = {1, 3, 2};
        nextPermutation.nextPerm(testCase1);
        System.out.println("Test case 1: " + (Arrays.equals(testCase1, expectedOutput1) ? "Passed" : "Failed"));

        // Test case 2
        int[] testCase2 = {3, 2, 1};
        int[] expectedOutput2 = {1, 2, 3};
        nextPermutation.nextPerm(testCase2);
        System.out.println("Test case 2: " + (Arrays.equals(testCase2, expectedOutput2) ? "Passed" : "Failed"));

        // Test case 3
        int[] testCase3 = {1, 1, 5};
        int[] expectedOutput3 = {1, 5, 1};
        nextPermutation.nextPerm(testCase3);
        System.out.println("Test case 3: " + (Arrays.equals(testCase3, expectedOutput3) ? "Passed" : "Failed"));
    }

}
