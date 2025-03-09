package February;

import DataStructure.TreeNode;

public class HeightOfBinaryTree
{
    private static int height(TreeNode node)
    {
        if(node == null){
            return 0;
        }
        int lHeight = 0, rHeight = 0;
        if(node.left != null){
            lHeight = height(node.left) + 1;
        }
        if(node.right != null){
            rHeight = height(node.right) + 1;
        }
        return Math.max(lHeight, rHeight);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.right = new TreeNode(4);
        System.out.println(height(node));
    }
}