package Leetcode;

import DataStructure.TreeNode;

public class AverageOfSubTree {
    
    private int[] averageSubTreeUtil(TreeNode root, int[] result){
        if(root != null){
            int[] currentR = new int[]{0,0};
            int[] leftS = averageSubTreeUtil(root.left, result);
            int[] rightS = averageSubTreeUtil(root.right, result);
            currentR[0] = leftS[0]+rightS[0]+root.data;
            currentR[1] = leftS[1]+rightS[1]+1;
            if(currentR[0]/currentR[1] == root.data)
                result[0]++;
            return currentR;
        }
        return new int[]{0,0};
    }

    public int averageOfSubtree(TreeNode root) {
        int[] result = new int[]{0};
        averageSubTreeUtil(root, result);
        return result[0];
    }

}
