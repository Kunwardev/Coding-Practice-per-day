package Leetcode;

import DataStructure.TreeNode;

class NodeValue{
    int minValue;
    int maxValue;
    int maxSize;

    public NodeValue(int minValue, int maxValue, int maxSize){
        this.maxSize = maxSize;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

}

public class LargestBinarySubTree {
    private static int findLargest(TreeNode root){
        return findLargestUtil(root).maxSize;
    }
        
    private static NodeValue findLargestUtil(TreeNode root) {
        if(root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        NodeValue left = findLargestUtil(root.left);
        NodeValue right = findLargestUtil(root.right);

        if(left.maxValue < root.data && right.minValue > root.data){
            // It is BST
            return new NodeValue(Math.min(root.data, left.minValue), Math.max(root.data, right.maxValue), left.maxSize+right.maxSize+1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static void main(String[] args) {
        
    }
}
