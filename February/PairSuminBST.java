package February;

import java.util.HashSet;

import DataStructure.TreeNode;


public class PairSuminBST {
    private boolean findTargetUtil(TreeNode root, int target, HashSet<Integer> set)
    {
        if(root == null)
            return false;
        if(set.contains(target - root.data))
            return true;
            set.add(root.data);
        return findTargetUtil(root.left, target, set) || findTargetUtil(root.right, target, set);
    }
    
    private boolean findTarget(TreeNode root, int target) {
        // Write your code here
        HashSet<Integer> map = new HashSet<>();
        return findTargetUtil(root, target, map);
    }
}
