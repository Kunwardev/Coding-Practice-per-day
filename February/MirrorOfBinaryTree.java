package February;
import DataStructure.TreeNode;

public class MirrorOfBinaryTree
{
    void mirror(TreeNode node) {
        // Your code here
        if(node == null)
            return;
        mirror(node.left);
        mirror(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        MirrorOfBinaryTree obj = new MirrorOfBinaryTree();
        obj.mirror(root);
        root.inOrder();
    }
}