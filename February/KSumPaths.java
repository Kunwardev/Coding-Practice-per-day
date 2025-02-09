package February;

import java.util.HashMap;

import DataStructure.TreeNode;

public class KSumPaths {

    private int sumKUtil(TreeNode root, int k, int sum)
    {
        if(root == null)
            return 0;
        int pathCount = 0;
        sum += root.data;
        if(sum == k)
            pathCount++;
        pathCount += sumKUtil(root.left, k, sum);
        pathCount += sumKUtil(root.right, k, sum);
        return pathCount;
    }

    public int sumK(TreeNode root, int k) {
        if(root == null)
            return 0;
        int result = sumKUtil(root, k, 0);
        result += sumK(root.left, k);
        result += sumK(root.right, k);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        KSumPaths k = new KSumPaths();
        System.out.println(k.sumK(root, 7));
    }

}