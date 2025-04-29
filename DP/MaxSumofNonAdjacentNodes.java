package DP;

import DataStructure.TreeNode;

public class MaxSumofNonAdjacentNodes
{
    class Pair{
        int include, exclude;
        public Pair(int include, int exclude){
            this.include = include;
            this.exclude = exclude;
        }
    }

    private Pair postOrder(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
        Pair left = postOrder(root.left);
        Pair right = postOrder(root.right);

        int include = root.data + left.exclude + right.exclude;
        int exclude = Math.max(left.exclude, left.include) + Math.max(right.exclude, right.include);
        return new Pair(include, exclude);

    }

    public int function(TreeNode root){
        Pair result = postOrder(root);
        return Math.max(result.exclude, result.include);
    }

}