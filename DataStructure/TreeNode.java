package DataStructure;

public class TreeNode{
    public int data;
    public TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }

    public void inOrder() {
        inOrderHelper(this);
    }

    private void inOrderHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left);
        System.out.print(node.data + " ");
        inOrderHelper(node.right);
    }
}