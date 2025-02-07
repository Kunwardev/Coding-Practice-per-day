package February;
import java.util.ArrayList;

import DataStructure.TreeNode;

public class BoundaryTreeTraversal {
    public static void main(String[] args) {
        BoundaryTreeTraversal obj = new BoundaryTreeTraversal();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        ArrayList<Integer> arr = obj.printBoundary(root);
        System.out.println(arr);
    }

    private void leftBoundaryTraversal(TreeNode node, ArrayList<Integer> result)
    {
        if(node != null)
        {
            if(node.left != null){
                result.add(node.data);
                leftBoundaryTraversal(node.left, result);
            } else if(node.right != null){
                result.add(node.data);
                leftBoundaryTraversal(node.right, result);
            }
        }
    }
    
    private void rightBoundaryTraversal(TreeNode node, ArrayList<Integer> result)
    {
        if(node != null)
        {
            if(node.right != null){
                rightBoundaryTraversal(node.right, result);
                result.add(node.data);
            } else if(node.left != null){
                rightBoundaryTraversal(node.left, result);
                result.add(node.data);
            }
        }
    }
    
    private void leavesTraversal(TreeNode node, ArrayList<Integer> result){
        if(node != null){
            leavesTraversal(node.left, result);
            if(node.left == null && node.right == null){
                result.add(node.data);
            }
            leavesTraversal(node.right, result);
        }
        
    }
    
    private void boundaryTraversalUtil(TreeNode node, ArrayList<Integer> result){
        if(node != null){
            result.add(node.data);
            leftBoundaryTraversal(node.left, result);
            leavesTraversal(node.left, result);
            leavesTraversal(node.right, result);
            rightBoundaryTraversal(node.right, result);
        }
    }

    private ArrayList<Integer> printBoundary(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        boundaryTraversalUtil(root, result);
        return result;
    }

}
