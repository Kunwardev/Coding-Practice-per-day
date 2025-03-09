package February;

import java.util.HashMap;

import DataStructure.TreeNode;

public class KSumPaths {

    // This is the preferred method as it uses PrefixSum Technique and does not do much recursion
    // that was done in the first commit of this problem
    private int sumKUtil(TreeNode root, int k, int sum, HashMap<Integer, Integer> prefixSum){
        if(root == null)
            return 0;
        int pathCount = 0;
        sum += root.data;
        if(sum == k)
            pathCount++;
        pathCount += prefixSum.getOrDefault(sum-k, 0);
        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        pathCount += sumKUtil(root.left, k, sum, prefixSum);
        pathCount += sumKUtil(root.right, k, sum, prefixSum);
        prefixSum.put(sum, prefixSum.get(sum)-1);
        return pathCount;
    }

    public int sumK(TreeNode root, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        return sumKUtil(root, k, 0, prefixSum);
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