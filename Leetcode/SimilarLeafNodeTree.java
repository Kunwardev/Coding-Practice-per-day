package Leetcode;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

public class SimilarLeafNodeTree {
    
    private void getChildren(TreeNode root, List<Integer> arr){
        if(root != null){
            getChildren(root.left, arr);
            if(root.left == null && root.right == null)
                arr.add(root.data);
            getChildren(root.right, arr);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> chr1 = new ArrayList<>();
        List<Integer> chr2 = new ArrayList<>();
        getChildren(root1, chr1);
        getChildren(root2, chr2);
        return chr1.equals(chr2);
    }

}
