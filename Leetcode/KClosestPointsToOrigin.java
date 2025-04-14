package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> ((int)Math.sqrt(a[0]*a[0]+a[1]*a[1]) - (int)Math.sqrt(b[0]*b[0] + b[1]*b[1]) ));
        for(int[] i: points){
            pq.add(i);
        }
        while(!pq.isEmpty()){
            int[] test = pq.poll();
            System.out.println(test[0] + " " + test[1]);
        }
        return null;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();

        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        int[][] result1 = solution.kClosest(points1, k1);
        System.out.println("Test Case 1: " + Arrays.deepToString(result1));

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        int[][] result2 = solution.kClosest(points2, k2);
        System.out.println("Test Case 2: " + Arrays.deepToString(result2));

        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int k3 = 3;
        int[][] result3 = solution.kClosest(points3, k3);
        System.out.println("Test Case 3: " + Arrays.deepToString(result3));
    }

}
