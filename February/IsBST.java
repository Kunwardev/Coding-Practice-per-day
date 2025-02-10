package February;

import DataStructure.TreeNode;

public class IsBST{

    private boolean isBSTreeUtil(TreeNode root, int min, int max){
        if(root != null){
            if(root.data < min || root.data > max)
                return false;
            return isBSTreeUtil(root.left, min, root.data) && isBSTreeUtil(root.right, root.data, max);
        }
        return true;
    }

    public boolean isBSTree(TreeNode root){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isBSTreeUtil(root, min, max);
    }

}