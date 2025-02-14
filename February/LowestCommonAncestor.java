package February;
import DataStructure.TreeNode;

public class LowestCommonAncestor {
    
    private static TreeNode LCA(TreeNode root, int n1, int n2){
        if(root == null)
            return null;
        if(root.data == n1 || root.data == n2)
            return root;
        TreeNode leftLCA = LCA(root.left, n1, n2);
        TreeNode rightLCA = LCA(root.right, n1, n2);
        if(leftLCA != null && rightLCA != null)
            return root;
        return (leftLCA != null) ? leftLCA : rightLCA;    
    }

    

}
