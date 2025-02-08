package February;

import DataStructure.TreeNode;

public class MaxPathSumFromAnyNode {
    
    int maxSum = Integer.MIN_VALUE;
    
    int findMaxSum(TreeNode node) {
        // your code goes here
        maxSumUtil(node);
        return maxSum;
    }
    
    private int maxSumUtil(TreeNode node){
        if(node == null)
            return 0;
        int leftSum = maxSumUtil(node.left);
        int rightSum = maxSumUtil(node.right);
        int singlePathMax = Math.max(Math.max(leftSum, rightSum) + node.data, node.data);
        maxSum = Math.max(Math.max(singlePathMax, node.data+leftSum+rightSum), maxSum);
        return singlePathMax;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        MaxPathSumFromAnyNode maxPathSum = new MaxPathSumFromAnyNode();
        System.out.println("Maximum path sum is: " + maxPathSum.findMaxSum(root));
    }

}