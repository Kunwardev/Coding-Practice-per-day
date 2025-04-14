package Leetcode;

import java.util.HashMap;

public class LargestOutlierinArray {
    
    // Total Sum will be 2 * Sum + outlier ( Since one of the number is sum of the n-2 numbers),
    // so, we will put them all in map, 
    // then use the above equation to check if the current number is the outlier,
    // if the frequency is more than 1
    public int getLargestOutlier(int[] nums) {
        int totalSum = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num: nums){
            totalSum += num;
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        }   
        int outlier = Integer.MIN_VALUE;
        for(int num: nums){
            int potential = totalSum - 2 * num;
            if(hmap.containsKey(potential)){
                if(hmap.get(potential) > 1 || potential != num){
                    outlier = Math.max(potential, outlier);
                }
            }
        }
        return outlier;
    }

    public static void main(String[] args) {
        LargestOutlierinArray solution = new LargestOutlierinArray();

        // Test case 1
        int[] nums1 = {1,1,1,1,1,5,5};
        int result1 = solution.getLargestOutlier(nums1);
        System.out.println("Test case 1: " + result1); // Expected output: 5

        // Test case 2
        int[] nums2 = {-2,-1,-3,-6,4};
        int result2 = solution.getLargestOutlier(nums2);
        System.out.println("Test case 2: " + result2); // Expected output: 4

        // Test case 3
        int[] nums3 = {2,3,5,10};
        int result3 = solution.getLargestOutlier(nums3);
        System.out.println("Test case 3: " + result3); // Expected output: 10
    }

}
