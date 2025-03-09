package February;
import DataStructure.TreeNode;

class Result{
    int data;

    public Result() {
        this.data = 0;
    }
}

public class DiameterOfBinaryTree {
    int diameterRecur(TreeNode root, Result result){
        if(root == null)
            return 0;
        int lHeight = diameterRecur(root.left, result);
        int rHeight = diameterRecur(root.right, result);
        result.data = Math.max(result.data, lHeight + rHeight);
        return 1 + Math.max(lHeight, rHeight);
    }
    
    int diameter(TreeNode root) {
        // Your code here
        Result result = new Result();
        diameterRecur(root, result);
        return result.data;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(obj.diameter(root));
    }
}