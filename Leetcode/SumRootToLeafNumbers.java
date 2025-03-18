package Leetcode;

import DataStructure.TreeNode;

public class SumRootToLeafNumbers{

    private void sumNumbersUtil(TreeNode root, StringBuilder s, int[] result){
        if(root != null){
            s.append(root.data+"");
            if(root.left == null && root.right == null){
                System.out.println(s.toString());
                result[0] += Integer.parseInt(s.toString());
                return;
            }
            sumNumbersUtil(root.left, s, result);
            s.setLength(Math.max(s.length() - 1, 0));
            sumNumbersUtil(root.right,s, result);
            s.setLength(Math.max(s.length() - 1, 0));
        }
    }

    public int sumNumbers(TreeNode root) {
        int[] result = new int[1];
        if(root == null)
            return 0;
        StringBuilder s = new StringBuilder();
        sumNumbersUtil(root, s, result);
        return result[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumRootToLeafNumbers s = new SumRootToLeafNumbers();
        int ans = s.sumNumbers(root);
        System.out.println(ans);
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(1);
        ans = s.sumNumbers(root1);
        System.out.println(ans);
    }

}