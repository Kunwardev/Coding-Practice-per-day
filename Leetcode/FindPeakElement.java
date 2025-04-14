package Leetcode;

public class FindPeakElement {
    
    public int findElement(int[] arr){
        int left = 0, right = arr.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(arr[mid] > arr[mid+1]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement finder = new FindPeakElement();
        int[] testCase1 = {1, 2, 3, 1};
        int result1 = finder.findElement(testCase1);
        System.out.println("Test Case 1: " + result1); // Expected output: 2

        int[] testCase2 = {1, 2, 1, 3, 5, 6, 4};
        int result2 = finder.findElement(testCase2);
        System.out.println("Test Case 2: " + result2); // Expected output: 1 or 5
    }

}
