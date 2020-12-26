/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Tree;

/**
 *
 * @author DEV
 */
public class SortedArrayToBST {
    private static TreeNode function(int[] array, int low, int high){
        if(low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = function(array, low, mid-1);
        node.right = function(array, mid+1, high);
        return node;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        TreeNode root = function(arr, 0, arr.length-1);
        System.out.println(root.left.data + " " + root.data + " " + root.right.data);
    }
    
}
