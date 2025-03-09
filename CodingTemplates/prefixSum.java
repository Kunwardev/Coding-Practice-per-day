package CodingTemplates;

import java.util.*;

public class prefixSum{
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Initial sum = 0 and count = 1 in HashMap
        map.put(0, 1);
        
        for(int num : nums){
            sum += num;

            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            
            // map.put(sum, updated_value)
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args){
        prefixSum p = new prefixSum();
        int t = subarraySum(new int[] {1,2,3,4,5}, 5);
        System.out.println(t);
    }
}