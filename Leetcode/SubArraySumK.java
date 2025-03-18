package Leetcode;

import java.util.HashMap;

public class SubArraySumK {
    
    private int subArraySum(int[] arr, int k){
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int sum = 0, result = 0;
        prefixMap.put(0, 1);
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(prefixMap.containsKey(sum-k))
                result += prefixMap.get(sum-k);
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0)+1);
        }
        System.out.println(prefixMap + " "+ result);
        return result;
    }

    public static void main(String[] args) {
        SubArraySumK subArraySumK = new SubArraySumK();

        int[] testArray1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test Case 1: " + (subArraySumK.subArraySum(testArray1, k1) == 2));

        int[] testArray2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Test Case 2: " + (subArraySumK.subArraySum(testArray2, k2) == 2));

        int[] testArray3 = {1, -1, 1, -1, 1};
        int k3 = 0;
        System.out.println("Test Case 3: " + (subArraySumK.subArraySum(testArray3, k3) == 4));

        int[] testArray4 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k4 = 7;
        System.out.println("Test Case 4: " + (subArraySumK.subArraySum(testArray4, k4) == 4));
    }

}
