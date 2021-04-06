/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Tree;

/**
 *
 * @author kunwar
 */
public class ConstructingTreeFromArrayinPreorder {

    private static TreeNode functionUtil(int[] data, char[] preLN, Index myIndex, int n, TreeNode root) {
        int index = myIndex.index;
        root = new TreeNode(data[index]);
        myIndex.index++;
        if(preLN[index] == 'N'){
            root.left = functionUtil(data, preLN, myIndex, n, root.left);
            root.right = functionUtil(data, preLN, myIndex, n, root.right);
        }
        return root;
    }
    
    static class Index{
        int index = 0;
    }
    
    static void printInorder(TreeNode node) 
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    
    private static TreeNode function(int[] data, char[] preLN, int n, TreeNode root){
        Index myIndex = new Index();
        return functionUtil(data, preLN, myIndex, n, root);
    }
    
    public static void main(String[] args) {
        int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        TreeNode root = new TreeNode(0);
        root = function(pre, preLN, pre.length, root);
        printInorder(root);
    }
    
}
