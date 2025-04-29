package DP;

/*
 * The score of an array is defined as the product of its sum and its length.

For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.

A subarray is a contiguous sequence of elements within an array.
 */

public class CountSubArraysWithScoreLessK {
    
    private long countSubarrays(int[] nums, int k){
        int n = nums.length;
        int start = 0, end = 0, sum = 0;
        long count = 0;
        for(;end<n;end++){
            sum += nums[end];
            while((long) sum * (end - start + 1) >= k) { // Cast to long to prevent overflow
                sum -= nums[start];
                start++;
            }
            count += (end-start+1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubArraysWithScoreLessK solution = new CountSubArraysWithScoreLessK();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        int k1 = 10;
        long expectedOutput1 = 4; // Subarrays: [1], [2], [3], [1,2]
        long actualOutput1 = solution.countSubarrays(nums1, k1);
        System.out.println(actualOutput1);
        System.out.println("Test case 1: " + (expectedOutput1 == actualOutput1 ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {2, 1, 4, 3, 5};
        int k2 = 10;
        long expectedOutput2 = 6; // Subarrays: [2], [1], [4], [3], [2,1], [1,4], [4,3], [2,1,4]
        long actualOutput2 = solution.countSubarrays(nums2, k2);
        System.out.println("Test case 2: " + (expectedOutput2 == actualOutput2 ? "Passed" : "Failed"));

        // Test case 3
        int[] nums3 = {1, 1, 1};
        int k3 = 5;
        long expectedOutput3 = 5; // Subarrays: [1], [1], [1], [1,1], [1,1], [1,1,1]
        long actualOutput3 = solution.countSubarrays(nums3, k3);
        System.out.println("Test case 3: " + (expectedOutput3 == actualOutput3 ? "Passed" : "Failed"));

        // Test case 4
        int[] nums4 = {5, 2, 1};
        int k4 = 10;
        long expectedOutput4 = 4; // Subarrays: [5], [2], [1], [2,1]
        long actualOutput4 = solution.countSubarrays(nums4, k4);
        System.out.println("Test case 4: " + (expectedOutput4 == actualOutput4 ? "Passed" : "Failed"));

    
    }

}
